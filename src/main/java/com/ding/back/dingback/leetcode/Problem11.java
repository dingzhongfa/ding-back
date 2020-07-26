package com.ding.back.dingback.leetcode;

/**
 * @ClassName Problem
 * @Description
 * @Author dingzf
 * @Date 2020/7/13 7:52 下午
 */
public class Problem11 {
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxHeight = height[0];
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (height[i] < maxHeight) {
                continue;
            }
            maxHeight = height[i];
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int resultTemp = h * (j - i);
                if (resultTemp > result) {
                    result = resultTemp;
                }
            }
        }
        return result;
    }

    public static int betterMaxArea(int[] height) {
        int l = height.length, lo = 0, hi = l-1;
        int max = 0;
        while(lo<hi) {
            int loMax = height[lo], hiMax = height[hi];

            int candidate = (hi-lo) * (Math.min(loMax, hiMax));
            max = Math.max(candidate, max);

            if(height[lo]<=height[hi]) {
                while(lo<hi && height[lo]<=loMax) {
                    ++lo;
                }
            } else {
                while(hi>lo && height[hi]<=hiMax) {
                    --hi;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(testArr));
    }
}
