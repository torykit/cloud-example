package com.example.cloud.server.b.api.impl;

import com.example.cloud.basic.module.constant.ServicesNameConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@FeignClient(serviceId = ServicesNameConstant.SERVER_B)
@RequestMapping("test-user")
public interface TestServerBApi {

    /**
     * test
     * @return
     */

    @GetMapping("info")
    String info();

    /**
     * 测试自动配置
     * @return
     */
    @GetMapping("testBean")
    String testBean();
}
