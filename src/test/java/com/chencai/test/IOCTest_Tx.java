package com.chencai.test;

import com.chencai.aop.MathCalculator;
import com.chencai.config.MainConfigOfAOP;
import com.chencai.tx.TxConfig;
import com.chencai.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.inserUser();

        applicationContext.close();
    }
}
