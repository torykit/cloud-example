package com.example.cloud.server.c.controller;

import com.example.cloud.server.c.api.impl.TestServerCApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@Slf4j
@RestController
@RequestMapping("test-user-c")
public class TestServerBApiController implements TestServerCApi {

    @Value("${server.port}")
    private String port;


    @Override
    public String info() {
        return "hello I am server-c port :" + port;
    }

    @Override
    public String testBean() {
        log.info("in test Bean");
        return "in test Bean";
    }


}
