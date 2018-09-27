package com.example.cloud.server.a.controller;

import com.example.cloud.server.a.api.TestConfigApi;
import com.example.cloud.server.b.api.TestServerBApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhen.zhao01
 * @CreateDate 2018/9/27
 */
@RestController
@RefreshScope
@RequestMapping("test")
public class TestConfigController implements TestConfigApi {

    private static final Logger LOG = LoggerFactory.getLogger(TestConfigController.class);

    @Autowired
    private TestServerBApi testServerBApi;

    @Value("${branch}")
    private String branch;

    @Value("${name}")
    private String name;

    @Override
    @GetMapping("config")
    public String config() {

        LOG.info("====> branch: " + branch);
        LOG.info("====> name: " + name);

        return branch + ":" + name;
    }

    @GetMapping("accessServerB")
    public String accessServerB() {
        return testServerBApi.info();
    }


}
