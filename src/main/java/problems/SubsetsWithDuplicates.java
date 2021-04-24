package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 * Medium
 * <p>
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int ind, List<Integer> subList, List<List<Integer>> result) {
        result.add(subList);
        for (int i = ind; i < nums.length; ++i) {
            if (i > ind && nums[i - 1] == nums[i]) {
                continue;
            }
            List<Integer> newSublist = new ArrayList<>(subList);
            newSublist.add(nums[i]);
            helper(nums, i + 1, newSublist, result);
        }
    }
}
