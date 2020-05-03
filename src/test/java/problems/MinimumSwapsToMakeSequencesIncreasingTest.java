package problems;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSwapsToMakeSequencesIncreasingTest {

    private final MinimumSwapsToMakeSequencesIncreasing classUnderTest =
        new MinimumSwapsToMakeSequencesIncreasing();

    @Test
    public void test1() {
        int[] a = new int[]{1, 3, 5, 4};
        int[] b = new int[]{1, 2, 3, 7};

        int result = classUnderTest.minSwap(a, b);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] a = new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] b = new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20};

        int result = classUnderTest.minSwap(a, b);
        Assert.assertEquals(4, result);
    }

}
