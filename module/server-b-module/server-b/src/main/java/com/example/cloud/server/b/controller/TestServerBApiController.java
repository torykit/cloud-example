package com.example.cloud.server.b.controller;

import com.example.cloud.server.b.api.TestServerBApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@RestController
@RequestMapping("test-user")
public class TestServerBApiController implements TestServerBApi {

    @Value("${server.port}")
    private String port;

    @Override
    public String info() {
        return "hello I am server-b port :" + port;
    }
}
