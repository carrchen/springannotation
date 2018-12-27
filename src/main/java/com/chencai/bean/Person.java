package com.chencai.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {
    public Person() {
        System.out.println("Person初始化....");
    }

    private String name;
    private Integer age;
}
