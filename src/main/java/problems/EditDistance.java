package problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * 72. Edit Distance
 * <p>Hard
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        final char[] a = word1.toCharArray();
        final char[] b = word2.toCharArray();

        int[][] memo = new int[a.length][b.length];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return getDistance(a, a.length - 1, b, b.length - 1, memo);
    }

    private int getDistance(char[] a, int aInd, char[] b, int bInd, int[][] memo) {
        if (aInd < 0) {
            return bInd + 1;
        }
        if (bInd < 0) {
            return aInd + 1;
        }

        int distance = memo[aInd][bInd];
        if (distance != -1) {
            return distance;
        }

        if (a[aInd] == b[bInd]) {
            distance = getDistance(a, aInd - 1, b, bInd - 1, memo);
        } else {
            int substituteLast = getDistance(a, aInd - 1, b, bInd - 1, memo);
            int addLast = getDistance(a, aInd, b, bInd - 1, memo);
            int deleteLast = getDistance(a, aInd - 1, b, bInd, memo);

            distance = Math.min(substituteLast, Math.min(addLast, deleteLast));
            distance++;
        }

        memo[aInd][bInd] = distance;
        return distance;
    }
}
