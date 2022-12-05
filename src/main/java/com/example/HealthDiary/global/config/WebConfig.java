package com.example.HealthDiary.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
        registry
                .addMapping("/**")
            .allowedOrigins("http://localhost:3000")   // 추후 frontend 배포 ip 추가하기
//            .allowedHeaders("http://localhost:3000")
                .allowCredentials(true)
            .allowedMethods("*"); //get,post,patch 등 모든 허용할 HTTP method정의
    }

}