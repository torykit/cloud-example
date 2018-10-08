package com.example.cloud.server.a.api.impl;

import com.example.cloud.basic.module.constant.ServicesNameConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@FeignClient(serviceId = ServicesNameConstant.SERVER_A)
@RequestMapping("test")
public interface TestConfigApi {

    /**
     * 测试
     * @return
     */
    @GetMapping("config")
    String config();

}
