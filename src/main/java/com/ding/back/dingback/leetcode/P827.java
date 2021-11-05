package com.ding.back.dingback.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P827 {

    /**
     * 先找出所有的岛
     * 遍历所有为0的点，计算总和
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {

        int maxArea = 0;
        // 所有岛的集合
        Map<Integer, Integer> colorArea = new HashMap<>();
        // 给0赋值，后续统一处理
        colorArea.put(0, 0);

        int color = 100;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = dfs(grid, i, j, color);
                if (area != 0) {
                    maxArea = Math.max(maxArea, area);
                    colorArea.put(color, area);
                    color++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int totalArea = 1;
                    // 放在此处创建更直观，优化点是可以创建在循环外，每个循环结束clear
                    Set<Integer> colorSet = new HashSet<>();
                    if (i - 1 >= 0) {
                        totalArea = totalArea + colorArea.get(grid[i - 1][j]);
                        colorSet.add(grid[i - 1][j]);
                    }
                    if (j - 1 >= 0 && !colorSet.contains(grid[i][j - 1])) {
                        totalArea = totalArea + colorArea.get(grid[i][j - 1]);
                        colorSet.add(grid[i][j - 1]);
                    }
                    if (i + 1 < grid.length && !colorSet.contains(grid[i + 1][j])) {
                        totalArea = totalArea + colorArea.get(grid[i + 1][j]);
                        colorSet.add(grid[i + 1][j]);
                    }
                    if (j + 1 < grid[i].length && !colorSet.contains(grid[i][j + 1])) {
                        totalArea = totalArea + colorArea.get(grid[i][j + 1]);
                    }
                    maxArea = Math.max(maxArea, totalArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int color) {
        int area = 0;
        if (i == grid.length || j == grid[i].length || grid[i][j] != 1) {
            return area;
        }
        grid[i][j] = color;
        area += 1;
        if (i - 1 >= 0) {
            area = area + dfs(grid, i - 1, j, color);
        }
        if (j - 1 >= 0) {
            area = area + dfs(grid, i, j - 1, color);
        }
        if (i + 1 < grid.length) {
            area = area + dfs(grid, i + 1, j, color);
        }
        if (j + 1 < grid[i].length) {
            area = area + dfs(grid, i, j + 1, color);
        }
        return area;
    }

    public static void main(String[] args) {
        P827 p827 = new P827();
        int[][] grid = new int[2][2];
        grid[0] = new int[]{1, 0};
        grid[1] = new int[]{0, 1};
        System.out.println(p827.largestIsland(grid));
    }
}
