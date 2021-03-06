package problems;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * 801. Minimum Swaps To Make Sequences Increasing
 * <p>Medium
 *
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 * Note:
 *
 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
 * A[i], B[i] are integer values in the range [0, 2000].
 */
public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] a, int[] b) {
        int swap = 1, noSwap = 0;

        for (int i = 1; i < a.length; ++i) {
            boolean isIncreasingIfNoSwap = a[i - 1] < a[i] && b[i - 1] < b[i];
            boolean isIncreasingIfSwap = a[i - 1] < b[i] && b[i - 1] < a[i];

            if (isIncreasingIfNoSwap && isIncreasingIfSwap) {
                // Doesn't matter if i-1 is swapped or not, but we'll pick the min one
                int min = Math.min(swap, noSwap);
                noSwap = min;
                swap = min + 1;
            } else if (isIncreasingIfNoSwap) {
                // if i-1 was swapped, then this must be swapped, and vise versa
                // noSwap = noSwap;
                swap++;
            } else {
                // opposite action of i-1 must be taken
                int prevNoSwap = noSwap;
                noSwap = swap;
                swap = prevNoSwap;
                swap++;
            }
        }

        return Math.min(swap, noSwap);
    }
}
