package com.yutou.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "blog.alioss")
public class AliOssProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}