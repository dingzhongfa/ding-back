package com.ding.back.dingback.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P834 {

    int[] ans;
    int[] dp;
    int[] sz;
    List<List<Integer>> graph;

    /**
     * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
     * 输出: [8,12,6,10,10,10]
     * 解释:
     * 如下为给定的树的示意图：
     * 0
     * / \
     * 1   2
     * /|\
     * 3 4 5
     *
     * @param n
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        dp = new int[n];
        sz = new int[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs2(int m, int n) {
        ans[m] = dp[m];
        List<Integer> nodes = graph.get(m);
        for (int v : nodes) {
            if (v == n) {
                continue;
            }
            int dm = dp[m];
            int dv = dp[v];
            int sm = sz[m];
            int sv = sz[v];
            dp[m] -= dp[v] + sz[v];
            sz[m] -= sz[v];
            dp[v] += dp[m] + sz[m];
            sz[v] += sz[m];

            dfs2(v, m);

            dp[m] = dm;
            dp[v] = dv;
            sz[m] = sm;
            sz[v] = sv;

        }

    }

    private void dfs(int m, int n) {
        sz[m] = 1;
        dp[m] = 0;
        List<Integer> nodes = graph.get(m);
        for (int node : nodes) {
            if (node == n) {
                continue;
            }
            dfs(node, m);
            sz[m] += sz[node];
            dp[m] += dp[node] + sz[node];
        }
    }






    public static void main(String[] args) {
        P834 p834 = new P834();
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        p834.sumOfDistancesInTree(6, edges);
        System.out.println();

    }

}
