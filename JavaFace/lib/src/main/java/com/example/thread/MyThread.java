package com.example.thread;

class MyThread extends Thread {
   static Object resource = new Object();

    public MyThread(String name) {
        this.setName(name);
    }

    public void run() {
        synchronized (resource) {//同步语句块
            System.out.println(this.getName() + "线程访问了资料！！！");
            System.out.println(this.getName() + "线程带着锁睡觉去了！！！");
            try {
                Thread.sleep(5000);//睡5000ms后醒来
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "线程带着锁睡醒后释放了锁！！！");
        }
    }

    public static void main(String[] args) {

        MyThread mt1 = new MyThread("MT1");
        MyThread mt2 = new MyThread("MT2");
        mt1.start();
        mt2.start();
    }
}