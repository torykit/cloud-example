package com.trinasolar.cloud.modules.demo.server.a;

import com.trinasolar.cloud.core.constant.ApiConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhen.zhao01
 * @CreateDate 2018/9/26
 */
@EnableScheduling
@SpringBootApplication
@EnableFeignClients(basePackages = {ApiConstant.DEMO_SERVER_B, ApiConstant.DEMO_SERVER_C})
public class ServeraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeraApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
