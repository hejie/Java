package com.example.sorter;

import java.util.Comparator;

public interface Sorter<T> {

    /**
     * 排序
     *
     * @param list 待排序的数组
     */

    public void sort(T[] list);

    /**
     * 排序
     *
     * @param list 待排序的数组
     */

    public void sort(T[] list, Comparator comp);

}