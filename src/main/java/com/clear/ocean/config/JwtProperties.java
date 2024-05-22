package com.clear.ocean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import java.time.Duration;

/**
 * @author qml
 * @date 2024/5/15 11:03
 */
@Data
@ConfigurationProperties(prefix = "ocean.jwt")
public class JwtProperties {
    private Resource location;
    private String alias;
    private String password;
    private Duration tokenTTL;
}
