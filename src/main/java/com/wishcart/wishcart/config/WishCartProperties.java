package com.wishcart.wishcart.config;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "wishcart", ignoreUnknownFields = false)
@RequiredArgsConstructor
@Data
public class WishCartProperties {




    @Data
public static class ActiveMq{
    private String brokerUrl;
}
}
