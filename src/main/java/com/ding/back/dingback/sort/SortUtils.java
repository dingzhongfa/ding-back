package com.ding.back.dingback.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SortUtils
 * @Description sort
 * @Author dingzf
 * @Date 2020/7/13 7:14 下午
 */
public class SortUtils {


    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    public static  void  bubbleSort(int [] arr){

    }


    public static void main(String[] args) {
        int[] arr = new int[]{12, 324, 34, 345, 34, 5, 34, 45, 645, 645, 5, 56, 756, 7, 57, 56878, 6787, 67, 86, 678, 67, 867, 8, 7};
       selectSort(arr);

    }
}
