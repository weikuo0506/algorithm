package com.walker.algorithm.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by walker on 2017/3/19.
 */
public class InsertSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,5,4,2,1,7);
        System.out.println(list);
        System.out.println(insertSort1(list));
        System.out.println(list);
        System.out.println(insertSort2(list));

        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addAll(list);
        System.out.println(linkedList);
        insertSort3(linkedList);
        System.out.println(linkedList);
    }

    public static List<Integer> insertSort1(List<Integer> list) {
        List<Integer> sortedList = new LinkedList<Integer>();
        originIter:for (int num : list) {
            for(int i=0;i<sortedList.size();i++) {
                if (num < sortedList.get(i)) {
                    sortedList.add(i, num);
                    continue originIter;  //直接回到最外层循环，不再执行下面的添加；
                }
            }
            sortedList.add(num);
        }
        return sortedList;
    }

    public static List<Integer> insertSort2(List<Integer> list) {
        List<Integer> sortedList = new LinkedList<Integer>();
        for (int num : list) {
            boolean inserted = false;
            for(int i=0;i<sortedList.size();i++) {
                if (num < sortedList.get(i)) {
                    sortedList.add(i, num);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {   //只有没插入的情况下，才把当前值放到最后；
                sortedList.add(num);
            }
        }
        return sortedList;
    }

    /*
    for i = 1 to length(A)
        j ← i
        while j > 0 and A[j-1] > A[j]
            swap A[j] and A[j-1]
            j ← j - 1
        end while
    end for
     */
    public static void insertSort3(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }
            }
        }
    }


}
