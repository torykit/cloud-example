package com.example.cloud.basic.module.constant;

/**
 * @author zhen.zhao01
 * @date 2018/9/27
 */
public class ServicesNameConstant {

    /** 前缀添加到各模块中 只需设置developer_name 环境变量*/
    private static final String PREFIX = "${developer_name:}";

    public static final String SERVER_A = PREFIX + "server-a";

    public static final String SERVER_B = PREFIX + "server-b";

}
