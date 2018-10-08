package com.example.cloud.springboot.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhaozhen
 * @CreateDate 2018/4/2
 */
@Component
@ConfigurationProperties("swagger2")
public class SwaggerYmlResources {


    private List<Map<String, String>> resources = new ArrayList<>();

    public List<Map<String, String>> getResources() {
        return resources;
    }

    public SwaggerYmlResources setResources(List<Map<String, String>> resources) {
        this.resources = resources;
        return this;
    }
}
