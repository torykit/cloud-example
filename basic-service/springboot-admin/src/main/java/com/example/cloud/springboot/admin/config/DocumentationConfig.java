package com.example.cloud.springboot.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 配置swagger子服务
 *
 * @author zhaozhen
 * @CreateDate 2018/4/2
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {


    @Autowired
    private SwaggerYmlResources swaggerResourcesYml;

    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        for (Map<String, String> stringStringMap : swaggerResourcesYml.getResources()) {
            resources.add(swaggerResource(stringStringMap.get("name"), stringStringMap.get("location"), stringStringMap.get("version")));
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
