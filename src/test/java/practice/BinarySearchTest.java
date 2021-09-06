package practice;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void findHighestIndexSmallerOrEqualTo_ItemExists_returnsIndex(){
        int[] nums = new int[] {2,3,5};
        Assert.assertEquals(1, BinarySearch.findHighestIndexSmallerOrEqualTo(nums, 3));
    }
    @Test
    public void findHighestIndexSmallerOrEqualTo_SmallerItemExists_returnsIndex(){
        int[] nums = new int[] {2,5,5};
        Assert.assertEquals(0, BinarySearch.findHighestIndexSmallerOrEqualTo(nums, 3));
    }
    @Test
    public void findHighestIndexSmallerOrEqualTo_ItemDoesNotExist_returnsIndex(){
        int[] nums = new int[] {4,5,5};
        Assert.assertEquals(-1, BinarySearch.findHighestIndexSmallerOrEqualTo(nums, 3));
    }
}
