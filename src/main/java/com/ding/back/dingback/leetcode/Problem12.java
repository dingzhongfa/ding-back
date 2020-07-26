package com.ding.back.dingback.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Problem12
 * @Description
 * @Author dingzf
 * @Date 2020/7/14 9:41 上午
 */
public class Problem12 {

    public String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num / 1000] + c[num % 1000 / 100] + x[num % 100 / 10] + i[num % 10];


    }
}
