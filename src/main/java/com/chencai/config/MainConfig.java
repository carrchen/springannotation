package com.chencai.config;

import com.chencai.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(value = "com.chencai")
//@ComponentScan(value = "com.chencai", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//})
//@ComponentScan(value = "com.chencai", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("lisi", 20);
    }
}
