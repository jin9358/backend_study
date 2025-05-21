package com.korit.springboot.config;

import com.korit.springboot.ioc.BeanStudy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudyConfig {

    @Bean
    public BeanStudy beanStudy() {
        System.out.println("bean 생성");
        return new BeanStudy();
    }

//    @Bean
//    public Criteria criteria() {
//        return new Criteria();
//    }
}
