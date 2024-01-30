package com.blee.bleespring.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// lombok를 이용해 get,set을 이용하지 않고 @Getter,@Setter를 적어주면 알아서 설정해줌. 특정 변수에만 선언할수도 있음.
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}

