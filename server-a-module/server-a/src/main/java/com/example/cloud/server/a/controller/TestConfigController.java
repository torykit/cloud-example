package com.example.cloud.server.a.controller;

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

    @GetMapping("config")
    public String config() {

        System.out.println("====> branch: " + branch);

        return branch;
    }


}
