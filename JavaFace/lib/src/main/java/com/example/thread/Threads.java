package com.example.thread;

/**
 * Created by Administrator on 2015/8/11.
 */
public class Threads {


    private volatile static int m;

    public static void main(String[] args) {


        Threads threads = new Threads();
        threads.exec();
    }


    class Runnable1 implements Runnable {

        @Override
        public void run() {

            print();
        }
    }

    public synchronized void print() {
        m++;
    }


    public void exec() {
        Runnable1 r = new Runnable1();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(r);
            t.start();
        }
        System.out.println(Thread.currentThread().getId() + " ======= " + m++);
    }
}
