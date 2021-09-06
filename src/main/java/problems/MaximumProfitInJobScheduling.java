package problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * <p>We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
 * obtaining a profit of profit[i].
 *
 * <p>You're given the startTime, endTime and profit arrays, return the maximum profit you can take
 * such that there are no two jobs in the subset with overlapping time range.
 *
 * <p>If you choose a job that ends at time X you will be able to start another job that starts at
 * time X.
 */
public class MaximumProfitInJobScheduling {

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int size = startTime.length;
    Job[] jobs = new Job[size];

    for (int i = 0; i < size; ++i) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }

    Arrays.sort(jobs, Comparator.comparingInt(j -> j.endTime));

    int[] memo = new int[size]; // max profit completing i-th job
    memo[0] = jobs[0].profit;

    return maxProfit(jobs, size - 1, memo);
  }

  private int maxProfit(Job[] jobs, int index, int[] memo) {
    if (memo[index] != 0) {
      return memo[index];
    }
    int profit = jobs[index].profit;
    int prevJobIndex = findLatestJobEndingBefore(jobs, index);
    if (prevJobIndex != -1) {
      profit += maxProfit(jobs, prevJobIndex, memo);
    }
    profit = Math.max(profit, maxProfit(jobs, index - 1, memo));
    memo[index] = profit;
    return profit;
  }

  private int findLatestJobEndingBefore(Job[] jobs, int targetJobIndex) {
    int low = 0, high = targetJobIndex - 1;
    int result = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (jobs[mid].endTime <= jobs[targetJobIndex].startTime) {
        result = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return result;
  }

  private static class Job {
    int startTime, endTime, profit;

    public Job(int startTime, int endTime, int profit) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.profit = profit;
    }
  }
}
