package com.example.consume.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "endpoint")
@Getter @Setter
public class ConfigProperties {

    private String name;
    private String url;

}
