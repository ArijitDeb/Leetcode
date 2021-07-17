package problems;

import java.util.*;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 *
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class ShortestPathGridWithObstaclesElimination {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        Point start = new Point(0, 0, 0, k);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int px = p.x, py = p.y;
            if (px == m - 1 && py == n - 1) {
                return p.level;
            }
            for (int[] d : DIRS) {
                int newX = px + d[0];
                int newY = py + d[1];

                if (newX >= m || newY >= n || newX < 0 || newY < 0 ||
                        (grid[newX][newY] == 1 && p.k <= 0)) {
                    continue;
                }

                Point newP = new Point(newX, newY, p.level + 1, grid[newX][newY] == 0 ? p.k : p.k - 1);
                if (!visited.contains(newP)) {
                    visited.add(newP);
                    queue.add(newP);
                }
            }
        }
        return -1;
    }

    private static class Point {
        int x, y, level, k;

        public Point(int x, int y, int level, int k) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && k == point.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, k);
        }
    }
}


