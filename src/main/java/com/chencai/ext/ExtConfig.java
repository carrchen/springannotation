package com.chencai.ext;

import com.chencai.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理
 * BeanPostProcessor bean后置处理器
 * BeanFactoryPostProcessor
 */

@Configuration
@ComponentScan("com.chencai.ext")
public class ExtConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}
