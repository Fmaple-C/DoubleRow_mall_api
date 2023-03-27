package com.mall.doublerow.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName BaseSecurityConfig
 * @Description TODO
 * @Date 2023/3/27 17:10
 * @Version 1.0
 */
public class BaseSecurityConfig implements WebMvcConfigurer  {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
