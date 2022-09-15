package com.caict3in.server.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author daisx
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "application")
public class AppProperties {

    public String env = "";

    @Valid
    private Jwt jwt = new Jwt();


    @Getter
    @Setter
    public static class Jwt {
        private String header = "Authorization";
        private String prefix = "Bearer";
        // Access Token 过期时间
        @Min(5000L)
        private long accessTokenExpireTime = 7 * 24 * 3600 * 1000L;
        // Refresh Token 过期时间
        @Min(3600000L)
        private long refreshTokenExpireTime = 7 * 24 * 3600 * 1000L;
        //长度不少于512bits
        private String key = "";
        private String refreshKey = "";
    }

}
