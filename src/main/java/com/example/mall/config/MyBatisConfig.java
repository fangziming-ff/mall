package com.example.mall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ming
 * @date 2021/12/8 11:16
 */
@Configuration
@MapperScan({"com.example.mall.mbg.mapper","com.example.mall.dao"})
public class MyBatisConfig {
}
