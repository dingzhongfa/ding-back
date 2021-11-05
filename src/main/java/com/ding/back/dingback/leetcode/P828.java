package com.ding.back.dingback.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P828 {
    /**
     * 题目描述得比较复杂，简单来说就是对于一个字符串，若该字符串中只出现了一次的字符数量为k，那么就记这个子串得k分。现在给出一个字符串s，要求s的所有子串的总得分是多少。
     *
     * 题目描述的角度是从字符串出发的，我们也从单个字符的角度出发，例如样例ABC：
     *
     * 1、对于A，其可以在字符串A、AB、ABC中计分，那么其得分为3
     *
     * 2、对于B，其可以在字符串AB、B、BC、ABC中计分，那么其得分为4
     *
     * 3、对于C，其可以在字符串C、BC、ABC中计分，那么其得分为3
     *
     * 因此最终答案为10
     *
     *
     * 再看样例ABA：
     *
     * 1、对于第一个A，其可以在A、AB中计分，但不能在ABA中计分，因此其得分为2
     *
     * 2、对于B，其可以在AB、B、BA、ABA中计分，那么其得分为4
     *
     * 3、对于第二个A，其可以在BA、A中计分，但不能在ABA中计分，因此其得分为2
     *
     * 因此最终答案为8
     *
     *
     * 到了这里，可以得知对于单个字母而言，其得分就是其单独出现的所有子串的个数。
     *
     * @param s
     * @return
     */


    public int uniqueLetterString(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int before = 1;
            int after = 1;
            for (int m = i - 1; m >= 0; m--) {
                if (arr[m] != arr[i]) {
                    before++;
                } else {
                    break;
                }
            }
            for (int n = i + 1; n < arr.length; n++) {
                if (arr[n] != arr[i]) {
                    after++;
                } else {
                    break;
                }
            }

            sum += (before * after);
        }
        return sum;
    }


    public static void main(String[] args) {
        P828 p828 = new P828();
        System.out.println(p828.uniqueLetterString("LEETCODE"));
    }
}
