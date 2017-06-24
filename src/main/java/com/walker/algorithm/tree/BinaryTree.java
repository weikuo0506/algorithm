package com.walker.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by walker on 2017/3/11.
 * 二叉树，各种遍历，各种翻转
 */
public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T data) {
        this.data = data;
    }

    //递归前序遍历；父->left->right
    public static void preOrderRecursive(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData()+"\t");
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }

    //递归中序遍历；left->父->right
    public static void middleOrderRecursive(BinaryTree root) {
        if (root == null) {
            return;
        }
        middleOrderRecursive(root.getLeft());
        System.out.print(root.getData()+"\t");
        middleOrderRecursive(root.getRight());
    }

    //递归后序遍历；left->right->父
    public static void postOrderRecursive(BinaryTree root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.getLeft());
        postOrderRecursive(root.getRight());
        System.out.print(root.getData()+"\t");
    }

    //非递归前序遍历；父->left->right
    public static void preOrderNonRecursive(BinaryTree root) {
        List list = new ArrayList();
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        //only right children are stored to stack
        while (root != null) {
            //输出当前node值；
            list.add(root.getData());
            //将当前node的右节点入栈
            if (root.getRight() != null) {
                stack.push(root.getRight());
            }
            //前进到当前node的左子树，设为当前node
            root = root.getLeft();
            //如果当前node为空，则数据出栈,为当前node
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        System.out.println(list);
    }
    //左右翻转
    public static void reverse(BinaryTree root) {
        if (root == null) {
            return;
        }
        BinaryTree tmp = root.getLeft();
        reverse(root.getRight());
        root.setLeft(root.getRight());
        reverse(tmp);
        root.setRight(tmp);
    }

    public static BinaryTree reverse2(BinaryTree root) {
        if (root == null) {
            return null;
        }
        BinaryTree tmp = root.getLeft();
        BinaryTree tmp2 = root.getRight();
        root.setLeft(reverse2(tmp2));
        root.setRight(reverse2(tmp));
        return root;
    }

    //Test below
    public static void main(String[] args) {
        BinaryTree<String> a = new BinaryTree<String>("a");
        BinaryTree<String> b = new BinaryTree<String>("b");
        BinaryTree<String> c = new BinaryTree<String>("c");
        BinaryTree<String> d = new BinaryTree<String>("d");
        BinaryTree<String> e = new BinaryTree<String>("e");
        BinaryTree<String> f = new BinaryTree<String>("f");
        BinaryTree<String> g = new BinaryTree<String>("g");
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        System.out.println("preOrder: ");
        preOrderRecursive(a);
        System.out.println();
        System.out.println("middleOrder: ");
        middleOrderRecursive(a);
        System.out.println();
        System.out.println("postOrder: ");
        postOrderRecursive(a);
        System.out.println();
        System.out.println("preOrder nonRecursive: ");
        preOrderNonRecursive(a);

        //reverse the tree
        reverse2(a);
        System.out.println("preOrder after reverse:");
        preOrderRecursive(a);
    }

    //Getter and Setter below
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }
}
