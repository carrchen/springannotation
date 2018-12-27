package com.chencai.java8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Lambda 表达式的基础语法: java8中引入了一个 ->
 *
 * 语法格式一:无参数,无返回值
 *      () -> system.out.print("hello lambda");
 *
 * 语法格式二:有一个参数,并且无返回值
 *      (e) -> system.out.print(e);
 *      e -> system.out.print(e);
 *
 */

public class TestLambda2 {

    @Test
    public void test1() {
        final int num = 0;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world" + num);
            }
        };
        runnable.run();

        System.out.println("-------------------------------");

        Runnable runnable1 = () -> System.out.println("hello lambda!" +num);
        runnable1.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = e -> System.out.println(e);
        consumer.accept("hahaha");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("比较大小");
            return Integer.compare(x, y) == -1 ? x:y;
        };

        int compare = comparator.compare(3, 5);
        System.out.println(compare);
    }

    @Test
    public void test5() {
        String[] strs = {"aaa", "bbb", "ccc"};
        show(new HashMap<>());
    }

    public void show (Map<String, Integer> map) {}

    @Test
    public void test6() {
        Integer operation = operation(100, e -> e * e);
        System.out.println(operation);
    }

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 999.99),
            new Employee("李四", 28, 8999.99),
            new Employee("王五", 28, 3999.99),
            new Employee("赵六", 48, 4999.99),
            new Employee("田七", 58, 5999.99)
    );

    @Test
    public void test7() {
        System.out.println(employees);
        Collections.sort(employees, (x, y) -> {return  x.getAge()==y.getAge()? x.getName().compareTo(y.getName()) : Integer.compare(x.getAge(),y.getAge());});
        System.out.println("----------------------");
        System.out.println(employees);
    }

    @Test
    public void test8() {
        String s = strHandler("\t\t\t\t  soesliewoewt  ", e -> e.trim().toUpperCase());
        System.out.println(s);

        System.out.println("---------------------");
        Long op = op(2L, 4L, (x, y) -> x + y);
        System.out.println(op);
    }


    public String strHandler(String string, Function<String, String> function) {
        return function.apply(string);
    }

    public Long op(long l1, long l2, BiFunction<Long, Long, Long> biFunction) {
        System.out.println(l1 + l2);
        return biFunction.apply(l1,l2);
    }
}
