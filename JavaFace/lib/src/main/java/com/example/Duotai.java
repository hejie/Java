package com.example;

/**
 * Created by Administrator on 2015/8/5.
 */
public class Duotai {
    static public class A {
        public String str;


        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }


    }

    static class B extends A {
        public String show(B obj) {
            return ("B and B");
        }

        public String show(A obj) {
            return ("B and A");
        }
    }

    static class C extends B {
    }

    static class D extends B {
    }


    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a.show(b));
        System.out.println(a.show(c));
        System.out.println(a.show(d));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}
