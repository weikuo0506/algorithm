package com.walker.algorithm.reverse;

/**
 * Created by walker on 2017/3/19.
 */
public class ReverseString {
    public static void main(String[] args) {
        String test = "abcdefg";
        System.out.println(reverse2(test));

    }

    public static String reverse1(String origin) {
        StringBuilder sb = new StringBuilder();
        for(int i=origin.length()-1;i>=0;i--) {
            sb.append(origin.charAt(i));
        }
        return sb.toString();
    }

    public static String reverse2(String origin) {
        StringBuilder sb = new StringBuilder(origin);
        for(int i=0;i<sb.length()/2;i++) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
            sb.setCharAt(sb.length() - 1 - i, tmp);
        }
        return sb.toString();
    }
}
