package com.jlh.demowork.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-29 17:28
 * Description:
 */
@Configuration
public class CORSConfiguration implements WebMvcConfigurer {

    @Value("${cors.addrs}")
    private String corsAddrs;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (!StringUtils.isEmpty(corsAddrs)){
            registry.addMapping("/**")
            .allowedOrigins(corsAddrs.split(","));
        }else {
            registry.addMapping("/**");
        }
    }
}
