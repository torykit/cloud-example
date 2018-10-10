package com.example.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhen.zhao01
 * @date 2018/10/10
 */
@Configuration
public class SwaggerRouteConfig {

    private final static String SWAGGER_SERVICE_LB = "lb://springboot-admin";

    @Bean
    public RouteLocator swaggerRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/swagger-ui.html").uri(SWAGGER_SERVICE_LB))
                .route(r -> r.path("/webjars/**").uri(SWAGGER_SERVICE_LB))
                .route(r -> r.path("/swagger-resources/**").uri(SWAGGER_SERVICE_LB))
                .build()
                ;
    }

}
