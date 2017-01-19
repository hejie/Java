package com.example.linkedlist;

public class MyClass {
    public static void main(String[] args) {
        // byte list
        LinkedList<Byte> xs = new LinkedList<Byte>();
        xs.add(new Byte(String.valueOf(0)));
        xs.add(new Byte(String.valueOf(1)));
        Byte x = xs.iterator().next();
        // string list
        LinkedList<String> ys = new LinkedList<String>();
        ys.add("zero");
        ys.add("one");
        String y = ys.iterator().next();
        // string list list
        LinkedList<LinkedList<String>> zss = new LinkedList < LinkedList < String >> ();
        zss.add(ys);
        String z = zss.iterator().next().iterator().next();
        // string list treated as byte list
//        Byte w = ys.iterator().next(); // compile-time error


       Iterator ite= ys.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }

    }
}
