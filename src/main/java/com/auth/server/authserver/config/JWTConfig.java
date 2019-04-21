package com.auth.server.authserver.config;

import com.auth.server.authserver.handler.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JWTFilter> filterRegistrationBean(){
        FilterRegistrationBean<JWTFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(jwtFilter);
        filterRegistrationBean.addUrlPatterns("/secured/*");
        return filterRegistrationBean;
    }
}
