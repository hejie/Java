package com.example.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class TestDemo {

    public static  class Person {
        private String name;
        private int age;

    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Foo.B.class; // 取得Class对象
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class,int.class); // 对象实例化属性才会分配空间
        constructor.setAccessible(true);
        Foo.B obj = (Foo.B) constructor.newInstance("wwww",12);
        Field nameField = cls.getDeclaredField("name"); // 找到name属性
        Field idField = cls.getDeclaredField("id"); // 找到name属性
        nameField.setAccessible(true); // 解除封装了
        idField.setAccessible(true); // 解除封装了
//        nameField.set(obj, "张三"); // Person对象.name = "张三"
        System.out.println(nameField.get(obj)+"=="+idField.get(obj)); // Person对象.name
    }
}