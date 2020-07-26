package com.ding.back.dingback.leetcode;

/**
 * @ClassName Problem14
 * @Description
 * @Author dingzf
 * @Date 2020/7/23 8:33 下午
 */
public class Problem14 {

    public static void main(String[] args) {
        String[] strs = {"frgdertfgdf", "frer", "frty", "frwerwe"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        StringBuilder sb = new StringBuilder("");
        while (true) {
            Character pre = null;
            boolean flag = true;
            for (String str : strs) {
                if (i >= str.length()) {
                    flag = false;
                    break;
                }
                if (pre == null) {
                    pre = str.charAt(i);
                    continue;
                }
                if (pre != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(pre);
            } else {
                break;
            }
            i++;
        }
        return sb.toString();

    }

    public static String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String minString = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minString.length()) {
                minString = strs[i];
            }
        }

        for (String str : strs) {
            int index = 0;
            while (index < minString.length()) {
                if (str.charAt(index) == minString.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }

            minString = str.substring(0, index);
        }

        return minString;

    }
}
