package problems;

/**
 * https://leetcode.com/submissions/detail/334914090/
 * 
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        final int length = heights.length;
        int[] maxLeftIndexBoundaries = new int[length];
        int[] maxRightIndexBoundaries = new int[length];

        for (int i = 0; i < length; ++i) {
            int leftBoundary = i - 1;
            while (leftBoundary >= 0 && heights[leftBoundary] >= heights[i]) {
                leftBoundary = maxLeftIndexBoundaries[leftBoundary];
            }
            maxLeftIndexBoundaries[i] = leftBoundary;
        }

        for (int i = length - 1; i >= 0; --i) {
            int rightBoundary = i + 1;
            while (rightBoundary < length && heights[rightBoundary] >= heights[i]) {
                rightBoundary = maxRightIndexBoundaries[rightBoundary];
            }
            maxRightIndexBoundaries[i] = rightBoundary;
        }

        int maxArea = 0;

        for (int i = 0; i < length; ++i) {
            int width = maxRightIndexBoundaries[i] - maxLeftIndexBoundaries[i] - 1;
            int area = heights[i] * width;

            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
