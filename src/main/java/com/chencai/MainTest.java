package com.chencai;

import com.chencai.bean.Person;
import com.chencai.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
