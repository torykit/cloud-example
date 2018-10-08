package com.example.cloud.basic.module.config;

import com.example.cloud.basic.module.constant.BasicConstant;
import feign.Feign;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 解决同时使用FeignClient和RequestMapping注解,导致MVC重复注册的问题
 * @author zhen.zhao01
 * @date 2018/10/8
 */
@Configuration
@ConditionalOnClass({Feign.class})
@EnableFeignClients(basePackages = {BasicConstant.FEIGN_MODULE_SCAN_PACKAGE})
public class FeignClientBasicAutoConfig extends WebMvcAutoConfiguration.EnableWebMvcConfiguration {


    public FeignClientBasicAutoConfig(ObjectProvider<WebMvcProperties> mvcPropertiesProvider, ObjectProvider<WebMvcRegistrations> mvcRegistrationsProvider, ListableBeanFactory beanFactory) {
        super(mvcPropertiesProvider, mvcRegistrationsProvider, beanFactory);
    }

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping(){
            @Override
            protected boolean isHandler(Class<?> beanType) {
                return super.isHandler(beanType) &&
                        !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
            }
        };
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}