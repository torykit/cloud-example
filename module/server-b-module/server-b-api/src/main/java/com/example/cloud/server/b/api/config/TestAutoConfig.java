package com.example.cloud.server.b.api.config;

import com.example.cloud.server.b.api.model.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhen.zhao01
 * @date 2018/9/28
 */
@Configuration
public class TestAutoConfig {

    @Bean
    public TestBean testBean(){
        return TestBean.builder()
                .name("tom")
                .build();
    }
}
