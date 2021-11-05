package com.ding.back.dingback.leetcode;

public class P838 {

    public String pushDominoes(String dominoes) {
        char[] ans = new char[dominoes.length()];
        char[] arr = dominoes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '.') {
                ans[i] = arr[i];
                continue;
            } else {
                ans[i] = '.';
            }
            int flagLeft = 0;
            int flagRight = 0;
            for (int j = 1; j <= i || j < arr.length - i; j++) {
                if (flagLeft == 0 && i - j >= 0) {
                    if (arr[i - j] == 'R') {
                        flagLeft = 1;
                    }
                    if (arr[i - j] == 'L') {
                        flagLeft = 2;
                    }

                }
                if (flagRight == 0 && i + j < arr.length) {
                    if (arr[i + j] == 'L') {
                        flagRight = 1;
                    }
                    if (arr[i + j] == 'R') {
                        flagRight = 2;
                    }
                }
                if (flagLeft == 1 || flagRight == 1) {
                    if (flagLeft == 1 && flagRight == 1) {
                        ans[i] = '.';
                    } else if (flagLeft == 1) {
                        ans[i] = 'R';
                    } else if (flagRight == 1) {
                        ans[i] = 'L';
                    }
                    break;
                }
            }
        }
        String result = "";
        for (char c : ans) {
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        P838 p838 = new P838();
        System.out.println(p838.pushDominoes("R."));
    }
}
