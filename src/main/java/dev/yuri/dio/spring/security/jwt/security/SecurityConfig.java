package dev.yuri.dio.spring.security.jwt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPREFIX(String PREFIX) {
        SecurityConfig.PREFIX = PREFIX;
    }

    public static void setKEY(String KEY) {
        SecurityConfig.KEY = KEY;
    }

    public void setEXPIRATION(Long EXPIRATION) {
        SecurityConfig.EXPIRATION = EXPIRATION;
    }
}
