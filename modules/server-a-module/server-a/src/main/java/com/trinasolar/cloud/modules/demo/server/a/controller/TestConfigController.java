package com.trinasolar.cloud.modules.demo.server.a.controller;

import com.trinasolar.cloud.modules.demo.server.a.api.TestConfigApi;
import com.trinasolar.cloud.modules.demo.server.b.api.impl.TestServerBApi;
import com.trinasolar.cloud.modules.demo.server.c.api.TestServerCApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private TestServerCApi testServerCApi;

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

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("accessServerB")
    public String accessServerB() {

//        restTemplate.getForEntity("htto://server-b".....)

        return testServerBApi.info();
    }


    @GetMapping("accessServerC")
    public String accessServerC() {
        return testServerCApi.info();
    }


}
