package com.example.thread;

class MyThread extends Thread {
   static Object resource = new Object();

    public MyThread(String name) {
        this.setName(name);
    }

    public void run() {
        synchronized (resource) {//ͬ������
            System.out.println(this.getName() + "�̷߳��������ϣ�����");
            System.out.println(this.getName() + "�̴߳�����˯��ȥ�ˣ�����");
            try {
                Thread.sleep(5000);//˯5000ms������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "�̴߳�����˯�Ѻ��ͷ�����������");
        }
    }

    public static void main(String[] args) {

        MyThread mt1 = new MyThread("MT1");
        MyThread mt2 = new MyThread("MT2");
        mt1.start();
        mt2.start();
    }
}