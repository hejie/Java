package com.example.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


class Foo {


    public static void main(String[] args) throws Exception {

        Class<?> c1 = B.class;
        Field[] fs = c1.getFields();
        System.out.println("*******getFields()*********");
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getName());
        }
        System.out.println("*******getDeclaredFields()*********");
        fs = c1.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getName());
        }
        System.out.println("*******getMethods()*********");
        Method[] md = c1.getMethods();
        for (int i = 0; i < md.length; i++) {
            System.out.println(md[i].getName());
        }
        System.out.println("*******getDeclaredMethods()*********");
        md = c1.getDeclaredMethods();
        for (int i = 0; i < md.length; i++) {
            System.out.println(md[i].getName());
        }

        System.out.println("*******getConstructors()*********");
        Constructor[] con = c1.getConstructors();
        for (int i = 0; i < con.length; i++) {

            System.out.println(con[i]);
        }
        System.out.println("*******getDeclaredConstructors()*********");
        con = c1.getDeclaredConstructors();
        for (int i = 0; i < con.length; i++) {
            System.out.println(con[i]);
        }

//        System.out.println(c1.getConstructor(String.class, int.class));
//        Constructor<?> cons = c1.getConstructor(String.class,int.class) ;

    }

    public static void getConstructors() {

        Class temp = B.class;
        String className = temp.getName(); // 获取指定类的类名

        try {
            Constructor[] theConstructors = temp.getDeclaredConstructors(); // 获取指定类的公有构造方法

            for (int i = 0; i < theConstructors.length; i++) {
                int mod = theConstructors[i].getModifiers(); // 输出修饰域和方法名称
                System.out.print(Modifier.toString(mod) + " " + className + "(");

                Class[] parameterTypes = theConstructors[i].getParameterTypes(); // 获取指定构造方法的参数的集合
                for (int j = 0; j < parameterTypes.length; j++) { // 输出打印参数列表
                    System.out.print(parameterTypes[j].getName());
                    if (parameterTypes.length > j + 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取参数类型，返回值保存在Class[]中
     */
    public Class[] getParamTypes(Class cls, String mName) {
        Class[] cs = null;

/*
         * Note: 由于我们一般通过反射机制调用的方法，是非public方法
         * 所以在此处使用了getDeclaredMethods()方法
*/
        Method[] mtd = cls.getDeclaredMethods();
        for (int i = 0; i < mtd.length; i++) {
            if (!mtd[i].getName().equals(mName)) {    // 不是我们需要的参数，则进入下一次循环
                continue;
            }

            cs = mtd[i].getParameterTypes();
        }
        return cs;
    }

    public static class B {
        private String name;
        private int id;

        public B() {
        }

        public B(String b) {
        }

        public B(int b) {
        }


        public B(String name, int id) {
            this.id = id;
            this.name = name;
        }

        public void b() {

        }

        @Override
        public String toString() {
            return "B{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    public class A {
        public A() {
        }

        public A(String a) {
        }

        public void a() {

        }
    }

}  