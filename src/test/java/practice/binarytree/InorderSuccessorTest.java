package practice.binarytree;

import org.junit.Assert;
import org.junit.Test;

public class InorderSuccessorTest {

  @Test
  public void test() {
    /*
               1
           2       3
        4     5
                 6
    */
    InorderSuccessor.TreeNode six = InorderSuccessor.TreeNode.builder().val(6).build();
    InorderSuccessor.TreeNode five = InorderSuccessor.TreeNode.builder().val(5).right(six).build();
    InorderSuccessor.TreeNode four = InorderSuccessor.TreeNode.builder().val(4).build();
    InorderSuccessor.TreeNode two =
        InorderSuccessor.TreeNode.builder().val(2).right(five).left(four).build();
    InorderSuccessor.TreeNode three = InorderSuccessor.TreeNode.builder().val(3).build();
    InorderSuccessor.TreeNode one =
        InorderSuccessor.TreeNode.builder().val(1).right(three).left(two).build();

    six.parent = five;
    five.parent = two;
    four.parent = two;
    two.parent = one;
    three.parent = one;

    Assert.assertEquals(two, InorderSuccessor.next(four));
    Assert.assertEquals(one, InorderSuccessor.next(six));
    Assert.assertEquals(five, InorderSuccessor.next(two));
    Assert.assertNull(InorderSuccessor.next(three));
  }
}
