package com.walker.algorithm.sort;

import java.util.Arrays;

/**
 * 排序算法
 * @author walkerwei
 * @version 2017/3/17
 */
public class SortUtil {
    public static void main(String[] args) {
        int[] numArray = new int[]{6,5,3,4,2,1};
        System.out.println(Arrays.toString(numArray));
//        List<Integer> list = Arrays.asList(3, 1, 8, 5, 6);
//        System.out.println(list);
        System.out.println(Arrays.toString(bubbleSort1(numArray)));
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static int[] bubbleSort1(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {  //思路：从j=0开始，最简单的第一次，但只能排好第一个元素；逐步类推，最后归纳规律；
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static int[] bubbleSort2(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {  //思路：从j=0开始，最简单的第一次，但只能排好第一个元素；逐步类推，最后归纳规律；
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }
        return nums;
    }


}
