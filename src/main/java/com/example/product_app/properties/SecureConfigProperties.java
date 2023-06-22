package com.example.product_app.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("service.security")
public class SecureConfigProperties {
    private String secureKeyUserName;
    private String secureKeyPassword;
}
