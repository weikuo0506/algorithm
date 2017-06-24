package com.walker.algorithm.search;

import com.walker.algorithm.sort.MergeSort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by walker on 2017/3/19.
 */
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,5,3,5,4,2,1,7);
        System.out.println(list);
        list = MergeSort.mergeSort1(list);
        System.out.println(list);

        //针对有序序列，二分查找
        System.out.println(binarySearch1(list, 5));
    }

    /**
     * 针对有序序列的二分查找
     * @param list
     * @param value
     * @return
     */
    public static boolean binarySearch1(final List<Integer> list, final int value) {
        if (list == null || list.size() == 0) {
            return false;
        }
        int middle = list.get(list.size() / 2);
        if (value == middle) {
            return true;
        } else if (value < middle) {
            List<Integer> lower = list.subList(0, list.size() / 2);
            return binarySearch1(lower, value);
        } else {
            List<Integer> higher = list.subList(list.size() / 2 + 1, list.size());
            return binarySearch1(higher, value);
        }
    }

}
