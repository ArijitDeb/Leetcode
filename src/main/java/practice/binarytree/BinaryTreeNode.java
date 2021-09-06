package practice.binarytree;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BinaryTreeNode<T> {
  T val;
  BinaryTreeNode left, right;

  public BinaryTreeNode(T val, BinaryTreeNode left, BinaryTreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public BinaryTreeNode(T val) {
    this.val = val;
  }
}
