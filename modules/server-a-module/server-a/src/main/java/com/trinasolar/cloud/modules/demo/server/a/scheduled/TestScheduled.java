package com.trinasolar.cloud.modules.demo.server.a.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhen.zhao01
 * @date 2018/10/10
 */
@Slf4j
@Component
public class TestScheduled {


    @SuppressWarnings("UnusedAssignment")
    @Scheduled(cron = "0/30 * * * * ?")
    public void sayHello() {
        log.info("=====================> hello world" );
    }


}
