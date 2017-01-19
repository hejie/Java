package com.example.reflect;

import java.lang.reflect.Constructor;

class Person { // CTRL + K
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Person.class; // 取得Class对象
// 取得指定参数类型的构造方法
        Constructor<?> cons = cls.getConstructor(String.class, int.class);
        Person obj = (Person) cons.newInstance("张三", 20); // 为构造方法传递参数
        System.out.println(obj.age);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
