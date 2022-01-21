package com.ding.back.dingback.tree;

public class ErgodicUtils {

    public static void printTreeBefore(TreeNode treeNode) {
        System.out.println(treeNode.getValue());
        printTreeBefore(treeNode.getLeft());
        printTreeBefore(treeNode.getRight());
    }

    public static void printTreeMid(TreeNode treeNode) {
        printTreeBefore(treeNode.getLeft());
        System.out.println(treeNode.getValue());
        printTreeBefore(treeNode.getRight());
    }

    public static void printTreeAfter(TreeNode treeNode) {
        printTreeBefore(treeNode.getLeft());
        printTreeBefore(treeNode.getRight());
        System.out.println(treeNode.getValue());
    }


    public static TreeNode arrToTree(int[] arr, int start, int end) {
        TreeNode result = new TreeNode();
        if (start == end) {
            result.setValue(arr[start]);
            return result;
        }
        int nodeValue = arr[start];
        for (int i = start + 1; i < end; i++) {
            if (arr[i] > nodeValue) {
                result.setValue(nodeValue);
                result.setRight(arrToTree(arr, i, end));
                result.setLeft(arrToTree(arr, start + 1, i));
            }
        }
        //没找到
        if (result.getValue() == null) {
            result.setValue(nodeValue);
            result.setLeft(arrToTree(arr, start + 1, end));
        }
        return result;
    }


}
