package com.ding.back.dingback.tree;

public class ErgodicUtils {

    public static void printTreeBefore(TreeNode treeNode){
        System.out.println(treeNode.getValue());
        printTreeBefore(treeNode.getLeft());
        printTreeBefore(treeNode.getRight());
    }

    public static void printTreeMid(TreeNode treeNode){
        printTreeBefore(treeNode.getLeft());
        System.out.println(treeNode.getValue());
        printTreeBefore(treeNode.getRight());
    }

    public static void printTreeAfter(TreeNode treeNode){
        printTreeBefore(treeNode.getLeft());
        printTreeBefore(treeNode.getRight());
        System.out.println(treeNode.getValue());
    }


}
