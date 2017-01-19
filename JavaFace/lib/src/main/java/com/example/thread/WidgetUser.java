package com.example.thread;

import java.util.ArrayList;
import java.util.List;


public class WidgetUser {

    static   class Widget {
    }

    static  class WidgetMaker extends Thread {
        List finishedWidgets = new ArrayList();

        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    Widget w = new Widget();
                    Widget i = new Widget();
                    Widget d = new Widget();
                    synchronized (finishedWidgets) {
                        finishedWidgets.add(w);
                        finishedWidgets.add(i);
                        finishedWidgets.add(d);
                        finishedWidgets.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
            }
        }


    }

    static  class WidgetRemove extends Thread {
        List finishedWidgets = new ArrayList();

        public void run() {
            waitForWiget();
        }

        public Widget waitForWiget() {
            synchronized (finishedWidgets) {
                if (finishedWidgets.size() == 0) {
                    try {
                        finishedWidgets.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(getName() + "got a widget");
                return (Widget) finishedWidgets.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        WidgetMaker maker = new WidgetMaker();
        maker.start();
        WidgetRemove remove = new WidgetRemove();
        remove.start();

    }

}
