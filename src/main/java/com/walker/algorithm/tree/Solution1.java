package com.walker.algorithm.tree;


/**
 * @author walkerwei
 * @version 2017/2/9
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
