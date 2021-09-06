package practice.binarytree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeInorderTraversalTest {

  private final BinaryTreeInorderTraversal classUnderTest = new BinaryTreeInorderTraversal();

  @Test
  public void getInorder_ValidTree_ReturnsNonEmptyList() {
    BinaryTreeNode binaryTree =
        new BinaryTreeNode(
            1, new BinaryTreeNode(2, new BinaryTreeNode(4), null), new BinaryTreeNode(3));

    Assert.assertEquals(
        Lists.newArrayList(4, 2, 1, 3), classUnderTest.getTraversalOrder(binaryTree));
  }

  @Test
  public void getTraversalOrderWithoutRecursion_ValidTree_ReturnsNonEmptyList() {
    BinaryTreeNode binaryTree =
        new BinaryTreeNode(
            1, new BinaryTreeNode(2, new BinaryTreeNode(4), null), new BinaryTreeNode(3));

    Assert.assertEquals(
        Lists.newArrayList(4, 2, 1, 3),
        classUnderTest.getTraversalOrderWithoutRecursion(binaryTree));
  }
}
