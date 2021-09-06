package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
  public int[][] kClosest(int[][] points, int k) {
    if (points == null || points.length == 0 || k == 0) {
      return new int[][] {{}};
    }
    PriorityQueue<Point> maxHeap =
        new PriorityQueue<>(k, Comparator.comparingDouble(Point::dist).reversed());
    for (int[] point : points) {
      maxHeap.add(new Point(point[0], point[1]));
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    int[][] ret = new int[k][2];
    int index = 0;
    while (!maxHeap.isEmpty()) {
      Point p = maxHeap.poll();
      ret[index++] = p.toArray();
    }

    return ret;
  }

  private static class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    double dist() {
      return Math.sqrt(x * x + y * y);
    }

    int[] toArray() {
      return new int[] {x, y};
    }
  }
}
/**
 * public int[][] kClosest(int[][] points, int K) { int len = points.length, l = 0, r = len - 1;
 * while (l <= r) { int mid = helper(points, l, r); if (mid == K) break; if (mid < K) { l = mid + 1;
 * } else { r = mid - 1; } } return Arrays.copyOfRange(points, 0, K); }
 *
 * <p>private int helper(int[][] A, int l, int r) { int[] pivot = A[l]; while (l < r) { while (l < r
 * && compare(A[r], pivot) >= 0) r--; A[l] = A[r]; while (l < r && compare(A[l], pivot) <= 0) l++;
 * A[r] = A[l]; } A[l] = pivot; return l; }
 *
 * <p>private int compare(int[] p1, int[] p2) { return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0]
 * - p2[1] * p2[1]; }
 */
