package com.mall.doublerow.config;


import com.mall.doublerow.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Date 2023/2/13 21:46
 * @Version 1.0
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig extends BaseSwaggerConfig{


    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.mall.doublerow.controller")
                .title("mall后台系统")
                .description("mall后台相关接口文档")
                .contactName("doublerow")
                .version("1.0")
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}
