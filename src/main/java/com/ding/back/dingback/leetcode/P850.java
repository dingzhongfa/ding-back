package com.ding.back.dingback.leetcode;

public class P850 {

    /**
     * [x11,y11,x12,y12],[x21,y21,x22,y22]
     * <p>
     * 1： [x21,y21,x12,y12]
     * 2:  [x21,y12,x12,y22]  +
     * 3:  [x12,y12,x22,y22] +
     * 4:  [x12,y21,x22,min(y12,y22)] +
     *
     * @param rectangles
     * @return
     */
    public int rectangleArea(int[][] rectangles) {
        int[] pre = null;
        long sum = 0;
        for (int[] item : rectangles) {
            if (pre == null) {
                sum += getArea(item);
                pre = item;
            } else {
                if (item[0] > pre[2] && item[1] > pre[3]) {
                    sum += getArea(item);
                    pre = item;
                    continue;
                }
                sum += getArea(new int[]{item[0], pre[3], pre[2], item[3]}) + getArea(new int[]{pre[2], pre[3], item[2], item[3]}) + getArea(new int[]{pre[2], item[1], item[2], Math.min(pre[3], item[3])});
                pre = item;
            }
        }
        return (int) (sum % (1e9 + 7));
    }

    public long getArea(int[] arr) {
        long area = (long) (arr[2] - arr[0]) * (arr[3] - arr[1]);
        return Math.max(area, 0);
    }

    public static void main(String[] args) {
        P850 p = new P850();
        int[][] rectangles = new int[3][4];
        /*rectangles[0] = new int[]{0,0,2,2};
        rectangles[1] = new int[]{1,0,2,3};
        rectangles[2] = new int[]{1,0,3,1};
        p.rectangleArea(rectangles);*/
        int[][] rectangles2 = new int[1][4];
        rectangles2[0] = new int[]{0, 0, 1000000000, 1000000000};
        System.out.println(p.rectangleArea(rectangles2));
    }
}
