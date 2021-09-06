package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * <p>Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
 * intervals, and return an array of the non-overlapping intervals that cover all the intervals in
 * the input.
 *
 * <p>Example 1:
 *
 * <p>Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation:
 * Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]. Example 2:
 *
 * <p>Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are
 * considered overlapping.
 *
 * <p>Constraints:
 *
 * <p>1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(
        intervals,
        (arr1, arr2) -> {
          {
            int ret = Integer.compare(arr1[0], arr2[0]);
            return ret == 0 ? Integer.compare(arr1[1], arr2[1]) : ret;
          }
        });

    List<int[]> result = new ArrayList<>();
    int[] cur = intervals[0];

    for (int i = 1; i < intervals.length; ++i) {
      int[] next = intervals[i];
      if (next[0] <= cur[1]) {
        cur[1] = Math.max(cur[1], next[1]);
      } else {
        result.add(cur);
        cur = next;
      }
    }
    result.add(cur);

    int[][] ret = new int[result.size()][2];
    int ind = 0;
    Iterator<int[]> it = result.iterator();
    while (it.hasNext()) {
      ret[ind++] = it.next();
    }
    return ret;
  }
}
