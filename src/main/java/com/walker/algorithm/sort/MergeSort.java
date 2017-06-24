package com.walker.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by walker on 2017/3/19.
 */
public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,5,3,5,4,2,1,7);
        System.out.println(list);
        System.out.println(mergeSort1(list));
    }

    public static List<Integer> mergeSort1(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> left = list.subList(0, list.size() / 2);  //[from,to)
        List<Integer> right = list.subList(list.size() / 2, list.size());
        return merge(mergeSort1(left), mergeSort1(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
        int i=0,j=0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                i++;
            }else if (left.get(i) > right.get(j)) {
                merged.add(right.get(j));
                j++;
            }else {  //含重复元素
                merged.add(left.get(i));
                i++;
                merged.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }
}
