package com.chencai.java8;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestLambda {

    @Test
    public void test1() {
        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }

    public void test2() {
        Comparator<Integer> comparator = (x,y) -> Integer.compare(2,y);
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 999.99),
            new Employee("李四", 28, 8999.99),
            new Employee("王五", 28, 3999.99),
            new Employee("赵六", 48, 4999.99),
            new Employee("田七", 58, 5999.99)
    );

    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test4() {
        List<Employee> employees = filterEmployee(this.employees, new FilterEmployeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("-----------------------");

        List<Employee> employees2 = filterEmployee(this.employees, new FilterEmployeeBySalary());
        for (Employee employee : employees2) {
            System.out.println(employee);
        }

    }


    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 35) {
                emps.add(employee);
            }
        }
        return emps;
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (myPredicate.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }


    @Test
    public void test5() {
        List<Employee> employees = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 4000;
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(this.employees, (e) -> e.getSalary() <= 5000);
        employees.forEach(System.out::println);
    }

    @Test
    public void test7() {
        employees.stream()
                .filter((e)->e.getSalary() > 3000)
                .limit(2)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
