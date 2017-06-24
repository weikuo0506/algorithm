package com.walker.algorithm.sort;

import java.util.Arrays;

/**
 * 排序算法
 * @author walkerwei
 * @version 2017/3/17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] numArray = new int[]{6,3,5,4,2,1};
        System.out.println(Arrays.toString(numArray));
//        List<Integer> list = Arrays.asList(6,3,5,4,2,1);
//        System.out.println(list);

        //排序
        bubbleSort5(numArray);
        System.out.println(Arrays.toString(numArray));
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort1(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {  //思路：从j=0开始，最简单的第一次，但只能排好第一个元素；逐步类推，最后归纳规律；
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort2(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {      //从上往下，重的下沉；
                if (nums[i] > nums[i + 1]) {
                    swap(nums,i,i+1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort3(int[] nums) {
        boolean swaped;
        do{
            swaped = false;         //一直循环；上一轮有swap则下一轮继续；直到没有swap则停止；感觉效率较低；
            for(int i=0;i<nums.length-1;i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swaped = true;
                }
            }
        }while (swaped);
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort4(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {   //最简洁；但感觉思路不像冒泡；拿第一个元素，依次与其他所有值比较，确定first；再拿第二个依次与其他值比较，确定second；
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }
    /*
        i∈[0,N-1)                //循环N-1遍
        j∈[0,N-1-i)            //每遍循环要处理的无序部分
        swap(j,j+1)          //两两排序（升序/降序）
    */
    public static void bubbleSort5(int[] nums) {  //与sort2本质类似，更易理解；
        for(int i=0;i<nums.length-1;i++) {
            for(int j=0;j<nums.length-1-i;j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int indexA, int indexB) {
        int tmp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = tmp;
    }




}
