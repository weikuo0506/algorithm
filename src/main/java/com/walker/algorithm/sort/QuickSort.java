package com.walker.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by walker on 2017/3/19.
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,5,4,2,1,7);
        System.out.println(list);
        System.out.println(quickSort1(list));
    }

    public static List<Integer> quickSort1(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int middle = list.get(0); //中间值
        List<Integer> lower = new LinkedList<Integer>();
        List<Integer> higher = new LinkedList<Integer>();
        for (int num : list) {
            if (num < middle) {
                lower.add(num);
            } else if (num > middle) {
                higher.add(num);
            }
        }
        List<Integer> sortedList = quickSort1(lower);
        sortedList.add(middle);
        sortedList.addAll(quickSort1(higher));
        return sortedList;
    }
}
