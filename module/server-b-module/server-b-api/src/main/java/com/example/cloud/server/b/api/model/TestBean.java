package com.example.cloud.server.b.api.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author zhen.zhao01
 * @date 2018/9/28
 */
@Builder
@ToString
public class TestBean {

    @NonNull
    private String name;

    private String password;
}
