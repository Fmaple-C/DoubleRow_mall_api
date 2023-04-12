package com.mall.doublerow.config;

import com.mall.doublerow.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Date 2023/4/12 15:25
 * @Version 1.0
 */
public class BaseSecurityJwtConfig implements WebMvcConfigurer {

    @Autowired
    private TokenFilter tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //.addPathPatterns()：增加url的拦截路径，“/**”意思是所有请求都要拦截；
        //.excludePathPatterns()：排除url的拦截路径，如："/login", "/register"意为登录和注册不做拦截；
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(getSecurity())
                .excludePathPatterns(getSwagger3Url());
        //指定该类拦截的url
    }

    private List<String> getSecurity () {
        List<String> urls = new ArrayList<>();
        urls.add("/userMember/login");
        urls.add("/userMember/register");
        urls.add("/home/**");
        urls.add("/psmProduct/**");
        return urls;
    }

    private List<String> getSwagger3Url()  {
        List<String> urls = new ArrayList<>();
        urls.add("/swagger-resources/**");
        urls.add("/webjars/**");
        urls.add("/swagger-ui.html/**");
        urls.add("/v2/**");
        return urls;
    }


}
