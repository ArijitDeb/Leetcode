package problems;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * <p>
 * Solution Approach:
 * Without days restriction, the least weight capacity needed is the max(weights) - this is the lower bound. And if we plan to ship everything in
 * a single day, then weight capacity needed is the sum(weights) - this is the higher bound. We'll use binary search
 * to find the lowest capacity between this bounds that satisfies the constraint of D days.
 */
public class ShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }

        int low = 0, high = 0;

        for (int n : weights) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int required = 1, cur = 0;

            for (int n : weights) {
                cur += n;
                if (cur > mid) {
                    if (++required > days) {
                        break;
                    }
                    cur = n;
                }
            }
            if (required > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

}
