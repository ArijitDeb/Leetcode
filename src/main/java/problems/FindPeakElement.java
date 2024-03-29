package problems;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * <p>A peak element is an element that is strictly greater than its neighbors.
 *
 * <p>Given an integer array nums, find a peak element, and return its index. If the array contains
 * multiple peaks, return the index to any of the peaks.
 *
 * <p>You may imagine that nums[-1] = nums[n] = -∞.
 *
 * <p>You must write an algorithm that runs in O(log n) time.
 */
public class FindPeakElement {

  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low < high) {
      int mid1 = (low + high) / 2;
      int mid2 = mid1 + 1;
      if (nums[mid1] < nums[mid2]) low = mid2;
      else high = mid1;
    }
    return low;
  }
}
