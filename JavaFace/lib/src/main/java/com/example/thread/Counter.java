package com.example.thread;

public class Counter {

    public volatile static int count = 0;

    public static void inc() {

        //这里延迟1毫秒，使得结果明显

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;

        System.out.println(Thread.currentThread().getId() + " Counter.count=" + Counter.count);
    }

    public static void main(String[] args) throws InterruptedException {

        //同时启动1000个线程，去进行i++计算，看看实际结果


        for (int i = 0; i < 1000; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public synchronized  void run() {
                    Counter.inc();
                }
            });
            thread.start();
            if (i % 5 == 0) {
//                thread.join();
//                System.out.println(Thread.currentThread().getId() + "=======================Counter.count=" + Counter.count);
            }

        }


        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("Counter.count=" + Counter.count);
    }
}