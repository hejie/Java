package com.example;


public class WeakReferenceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        A a = new A();
//        a.str = "Hello, reference";
//        WeakReference<A> weak = new WeakReference<A>(a);
//        a = null;
//        int i = 0;
//        while (weak.get() != null) {
//            System.out.println(String.format("Get str from object of WeakReference: %s, count: %d", weak.get().str, ++i));
//            if (i % 10 == 0) {
//                System.gc();
//                System.out.println("System.gc() was invoked!");
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//
//            }
//        }
        System.out.println("object a was cleared by JVM!");
    }

}
