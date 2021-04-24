package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int ind, List<Integer> subList, List<List<Integer>> result) {
        result.add(subList);
        for (int i = ind; i < nums.length; ++i) {
            List<Integer> newSublist = new ArrayList<>(subList);
            newSublist.add(nums[i]);
            helper(nums, i + 1, newSublist, result);
        }
    }
}
