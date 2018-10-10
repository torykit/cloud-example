package com.example.cloud.basic.module.config;

import com.example.cloud.basic.module.constant.BasicConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

/**
 * swagger2配置
 * @author zhen.zhao01
 * @date 2018/10/8
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = BasicConstant.YML_APP_SWAGGER_API,havingValue = BasicConstant.TRUE_S)
public class Swagger2Config {

    @Value("${spring.application.name}")
    public String applicationName;

    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
                // 因为通过gateway转发过来的请求, 导致basePath没法从servlet中获取
                // 所以统一规定使用 applicationName 来做basePath
                .pathProvider(new RelativePathProvider(servletContext){
                    @Override
                    public String getApplicationBasePath() {
                        return "/" + applicationName;
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
