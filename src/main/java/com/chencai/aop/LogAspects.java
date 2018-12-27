package com.chencai.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.chencai.aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.printf("除法运行...参数列表:%s,参数:%s",name, Arrays.asList(args));
        System.out.println();
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束...");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result) {
        System.out.printf("除法正常返回...运行结果:{%s}",result);
        System.out.println();
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.printf("除法异常...异常信息:{%s}",exception);
    }
}
