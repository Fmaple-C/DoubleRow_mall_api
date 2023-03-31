package com.mall.doublerow.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseSecurityConfig
 * @Description TODO
 * @Date 2023/3/27 17:10
 * @Version 1.0
 */
public class BaseSecurityConfig implements WebMvcConfigurer  {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能

    /*
     *
     *@Param
     *@Return
     **/
    private SaInterceptor saInterceptor() {
        return new SaInterceptor(handle -> {
            // 登录校验 -- 拦截所有路由，并排除/userManagement/login" 用于开放登录
            SaRouter
                    .match("/**")    // 拦截的 path 列表，可以写多个 */
                    .notMatch("/userMember/*","/psmProduct/*")
                    .notMatch(getSwagger3Url())
                    // 排除掉的 path 列表，可以写多个
                    .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
            // 根据路由划分模块，不同模块不同鉴权
            // 遍历校验规则，依次鉴权
        });
    }

    private List<String> getSwagger3Url()  {
        List<String> urls = new ArrayList<>();
        urls.add("/swagger-resources/**");
        urls.add("/webjars/**");
        urls.add("/swagger-ui.html/**");
        urls.add("/v2/**");
        return urls;
    }

    // Sa-Token 整合 jwt (Simple 简单模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }


}
