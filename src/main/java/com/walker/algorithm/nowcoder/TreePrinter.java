package com.walker.algorithm.nowcoder;

import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。

 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        LinkedList<TreeNode> storeList = new LinkedList<TreeNode>();
        List<List<TreeNode>> resultList = new ArrayList<List<TreeNode>>();
        storeList.add(root);

        TreeNode currentLevelRight = root;

        List<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
        while (!storeList.isEmpty()) {
            TreeNode current = storeList.removeFirst();
            currentLevelNodes.add(current);
            if (current.left != null) {
                storeList.add(current.left);
            }
            if (current.right != null) {
                storeList.add(current.right);
            }
            if (current == currentLevelRight) {
                //该换行了，还有行可换吗？先存已有结果，再看是否还有行可换！！！
                resultList.add(currentLevelNodes);
                if (!storeList.isEmpty()) {
                    currentLevelNodes = new ArrayList<TreeNode>();
                    currentLevelRight = storeList.getLast();
                }
            }
        }

        System.out.println(resultList);

        int[][] resultArray = new int[resultList.size()][];
        for(int i=0;i<resultList.size();i++) {
            resultArray[i] = new int[resultList.get(i).size()];
            for(int j=0;j<resultList.get(i).size();j++) {
                resultArray[i][j] = resultList.get(i).get(j).val;
            }
        }

        for (int[] ints : resultArray) {
            System.out.println(Arrays.toString(ints));
        }

        return resultArray;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        new TreePrinter().printTree(root);
    }
}