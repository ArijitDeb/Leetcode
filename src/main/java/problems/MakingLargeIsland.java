package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/making-a-large-island/
 * <p>
 * 827. Making A Large Island
 * <p>
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * <p>
 * Return the size of the largest island in grid after applying this operation.
 * <p>
 * An island is a 4-directionally connected group of 1s.
 *
 *
 * Solution:
 * For each 1, perform DFS to find the length of that island, color them, store that
 * into a Map<colorId, length>. Then for each 0, find it's unique neighbors' colors. Result is:
 * 1 + sum(length of each unique colored neighbors).
 */
public class MakingLargeIsland {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int max = -1;

        Map<Integer, Integer> colorCount = new HashMap<>();
        int colorId = 2; // 0 and 1 values already exist

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int length = dfs(i, j, grid, n, colorId);
                    colorCount.put(colorId++, length);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int length = 1;
                    Set<Integer> uniqueNeighbors = new HashSet<>();
                    for (int[] d : DIRS) {
                        int newX = i + d[0];
                        int newY = j + d[1];
                        if (newX < 0 || newX > n - 1 || newY < 0 || newY > n - 1 || grid[newX][newY] < 2) {
                            continue;
                        }
                        uniqueNeighbors.add(grid[newX][newY]);
                    }
                    length += uniqueNeighbors.stream().map(colorCount::get).reduce(0, Integer::sum);
                    max = Math.max(max, length);
                }
            }
        }
        return max == -1 ? n * n : max;
    }

    private int dfs(int x, int y, int[][] grid, int n, int colorId) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = colorId;
        int len = 0;
        for (int[] d : DIRS) {
            int newX = x + d[0];
            int newY = y + d[1];
            len += dfs(newX, newY, grid, n, colorId);
        }

        return len + 1;
    }

}
