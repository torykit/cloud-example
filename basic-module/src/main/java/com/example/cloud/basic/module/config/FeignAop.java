package com.example.cloud.basic.module.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author zhen.zhao01
 * @date 2018/10/9
 */

@Configuration
public class FeignAop implements SmartApplicationListener {

    private static boolean isExecute = false;

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return !isExecute;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return !isExecute;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        synchronized (this) {
            EnableFeignClients annotation = FeignAutoConfig.class.getAnnotation(EnableFeignClients.class);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
            Field field;
            try {
                field = invocationHandler.getClass().getDeclaredField("memberValues");
                field.setAccessible(true);
                Map<String, Object> map = (Map<String, Object>) field.get(invocationHandler);
                String[] s = {"com.example.cloud.server.b.api.impl"};
                map.put("basePackages",s );

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }




            isExecute = true;
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
