package com.example.sorter;

import java.util.Comparator;

public class BubbleSorter<T extends String> implements Sorter<T> {


    public static void main(String[] args) {
        BubbleSorter sorter = new BubbleSorter();

        String[] sts = new String[]{"5", "2", "3", "2", "1"};

        for (String str : sts) {
            System.out.print(str);
        }
        System.out.println("\n排序后");
        sorter.sort(sts);

        for (String str : sts) {
            System.out.print(str);
        }


        sorter.sort(sts, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }

    @Override

    public void sort(T[] list) {

        boolean swapped = true;

        for (int i = 1, len = list.length; i < len && swapped; ++i) {

            swapped = false;

            for (int j = 0; j < len - i; ++j) {

                if (list[j].compareTo(list[j + 1]) > 0) {

                    T temp = list[j];

                    list[j] = list[j + 1];

                    list[j + 1] = temp;

                    swapped = true;

                }

            }

        }

    }

    @Override
    public void sort(T[] list, Comparator comp) {

        boolean swapped = true;

        for (int i = 1, len = list.length; i < len && swapped; ++i) {

            swapped = false;

            for (int j = 0; j < len - i; ++j) {

                if (comp.compare(list[j], list[j + 1]) > 0) {

                    T temp = list[j];

                    list[j] = list[j + 1];

                    list[j + 1] = temp;

                    swapped = true;

                }

            }

        }

    }

}