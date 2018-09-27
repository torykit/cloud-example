package com.example.cloud.server.b.api;

import com.example.cloud.basic.module.constant.FeignApiConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@FeignClient(serviceId = FeignApiConstant.SERVER_B)
@RequestMapping("test-user")
public interface TestServerBApi {

    /**
     * test
     * @return
     */
    @GetMapping("info")
    String info();

}
