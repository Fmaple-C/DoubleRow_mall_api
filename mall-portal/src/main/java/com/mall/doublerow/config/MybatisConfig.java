package com.mall.doublerow.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Description TODO Mybatis
 * @Date 2023/2/14 15:41
 * @Version 1.0
 */
@Configuration
@MapperScan({"com.mall.doublerow.mapper","com.mall.doublerow.dao"})
public class MybatisConfig {
}
