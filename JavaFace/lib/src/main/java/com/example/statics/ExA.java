package com.example.statics;

public class ExA {
    static class ExC {
        static int a = 1;
        static {
            System.out.println("1");
        }

        {
            System.out.println("2");
        }

        public ExC() {
            System.out.println("3");
        }
    }

    static class ExB extends ExC {


        static {
            System.out.println("4");
        }

        {
            System.out.println("5");
        }

        public ExB() {
            System.out.println("6");
        }
    }


    public static void main(String[] args) {
//        ExB.a = 1;
        try {
            try {
                Class.forName("com.example.statics.ExA$ExB", true, ExA.class.getClassLoader()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


