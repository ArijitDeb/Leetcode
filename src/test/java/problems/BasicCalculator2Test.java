package problems;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculator2Test {

  BasicCalculator2 calculator = new BasicCalculator2();

  @Test
  public void test1() {
    Assert.assertEquals(7, calculator.calculate("3+2*2"));
    Assert.assertEquals(6, calculator.calculate("3+2+1"));
    Assert.assertEquals(6, calculator.calculate("3+3"));
    Assert.assertEquals(0, calculator.calculate("3-2-1"));
    Assert.assertEquals(-17, calculator.calculate("3-2*10"));
    Assert.assertEquals(3, calculator.calculate("3-2/10"));
    Assert.assertEquals(-2, calculator.calculate("3-5"));
  }
}
