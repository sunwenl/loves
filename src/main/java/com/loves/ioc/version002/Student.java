package com.loves.ioc.version002;

import lombok.Data;

@Data
public class Student extends Person {
    private int age;

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age+",name="+name +'}';
    }

}
