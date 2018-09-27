package com.example.cloud.server.a.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */

public interface TestConfigApi {

    /**
     * 测试
     * @return
     */
    @GetMapping("config")
    String config();

}
