package com.trinasolar.cloud.modules.demo.server.b.controller;

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
public class TestConfigController {

    @Value("${branch}")
    private String branch;

    @Value("${name}")
    private String name;

    @GetMapping("config")
    public String config() {

        System.out.println("====> branch: " + branch);
        System.out.println("====> name: " + name);

        return branch + ":" + name;
    }


}
