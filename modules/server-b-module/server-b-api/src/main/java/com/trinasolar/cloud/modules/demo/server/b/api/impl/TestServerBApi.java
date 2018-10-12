package com.trinasolar.cloud.modules.demo.server.b.api.impl;

import com.trinasolar.cloud.core.constant.ServicesNameConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
@FeignClient(serviceId = ServicesNameConstant.SERVER_B)
@RequestMapping("test-user")
public interface TestServerBApi {

    /**
     * http://xxxx:888/test-user/info
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



    @PostMapping("testA")
    void testA(@RequestBody Map<String,String> pama);
}
