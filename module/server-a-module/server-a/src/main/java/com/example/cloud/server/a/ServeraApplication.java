package com.example.cloud.server.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhen.zhao01
 * @CreateDate 2018/9/26
 */
@SpringBootApplication
public class ServeraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeraApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
