package com.bankapi.bankapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.config
 * @ProjectName bankapi
 * @ClassName WebConfig
 * @Email fudaopin@gamil.com
 * @date 2021/4/25 下午4:40
 * @Description 设置跨域访问
 */
@Configuration
public class WebConfig {
    
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);
            }
        };
    }
}
