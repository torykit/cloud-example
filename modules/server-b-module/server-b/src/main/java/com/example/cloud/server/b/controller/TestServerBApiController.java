package com.example.cloud.server.b.controller;

import com.example.cloud.server.b.api.impl.TestServerBApi;
import com.example.cloud.server.b.api.model.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@Slf4j
@RestController
@RequestMapping("test-user")
public class TestServerBApiController implements TestServerBApi {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TestBean testBean;

    @Override
    public String info() {
        return "hello I am server-b port :" + port;
    }

    @Override
    public String testBean() {
        log.info("in test Bean");
        return testBean.toString();
    }


}
