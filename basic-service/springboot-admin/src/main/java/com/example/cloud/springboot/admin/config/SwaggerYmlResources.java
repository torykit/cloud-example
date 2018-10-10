package com.example.cloud.springboot.admin.config;

import com.example.cloud.basic.module.constant.BasicConstant;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhaozhen
 * @CreateDate 2018/4/2
 */
@Data
@Component
@ConfigurationProperties(SwaggerYmlResources.PREFIX)
@ConditionalOnProperty(name = BasicConstant.YML_APP_SWAGGER_UI,havingValue = BasicConstant.TRUE_S)
public class SwaggerYmlResources {
    /**
     * 配置文件前缀
     */
    public static final String PREFIX = "swagger2";

    /**
     * swagger api接口地址
     */
    private String suffix = "v2/api-docs";

    /**
     * 默认全局version,可以被resource中的version所覆盖
     */
    private String version;

    /**
     * 接口信息, map中数据格式为:
     *  name 服务名称
     *  location 服务在gateway中的Path
     *  version 服务版本
     *  TODO: zhaozhen 需要把version添加到全局
     */
    private List<Map<String, String>> resources = new ArrayList<>();


}
