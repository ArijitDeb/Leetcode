package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * <p>Given an array of integers nums and an integer k, return the total number of continuous
 * subarrays whose sum equals to k.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,1,1], k = 2 Output: 2 Example 2:
 *
 * <p>Input: nums = [1,2,3], k = 3 Output: 2
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 2 * 104 -1000 <= nums[i] <= 1000 -107 <= k <= 107
 */
public class SubarraySumEqualsK {
  /**
   * Key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can
   * easily get SUM[i, j]. To achieve this, we just need to go through the array, calculate the
   * current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space
   * complexity O(n).
   */
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // sum, to how many times
    int res = 0, sum = 0;
    map.put(0, 1);

    for (int n : nums) {
      sum += n;
      res += map.getOrDefault(sum - k, 0);
      map.merge(sum, 1, Integer::sum);
    }
    return res;
  }
}
