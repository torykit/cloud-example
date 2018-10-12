package com.trinasolar.cloud.service.springboot.admin.config;

import com.trinasolar.cloud.core.constant.BasicConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 配置swagger子服务
 * TODO: zhaozhen 改造成从gateway配置文件中读取
 * @author zhaozhen
 * @CreateDate 2018/4/2
 */
@Component
@Primary
@ConditionalOnProperty(name = BasicConstant.YML_APP_SWAGGER_UI,havingValue = BasicConstant.TRUE_S)
public class DocumentationConfig implements SwaggerResourcesProvider {


    @Autowired
    private SwaggerYmlResources swaggerResourcesYml;


    @Override
    public List<SwaggerResource> get() {

        List<SwaggerResource> resources = new ArrayList<>(swaggerResourcesYml.getResources().size());
        for (Map<String, String> stringStringMap : swaggerResourcesYml.getResources()) {

            String location = stringStringMap.get("location");
            if (location.equals("/") || location.endsWith("/")) {
                location = location + swaggerResourcesYml.getSuffix();
            } else {
                location = location + "/" + swaggerResourcesYml.getSuffix();
            }

            resources.add(swaggerResource(
                    stringStringMap.get("name"),
                    location,
                    stringStringMap.get("version")
            ));
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }



}
