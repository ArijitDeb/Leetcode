package problems;

import org.junit.Assert;
import org.junit.Test;

public class NetworkDelayTimeTest {

    NetworkDelayTime networkDelayTime = new NetworkDelayTime();

    @Test
    public void test1() {
        Assert.assertEquals(2, networkDelayTime.networkDelayTime(new int[][]{{2,1,1}, {2,3,1},{3,4,1}}, 4, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, networkDelayTime.networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, networkDelayTime.networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
    }
}
