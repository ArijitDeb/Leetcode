package practice.binarytree;

import lombok.Builder;
import lombok.Data;

public class InorderSuccessor {

  public static TreeNode next(TreeNode node) {
    TreeNode iter = node;
    if (iter.right != null) {
      // return the leftmost child of right
      TreeNode result = iter.right;
      while (result.left != null) {
        result = result.left;
      }
      return result;
    }
    // find the closest ancestor whose left subtree has the current node
    while (iter.parent != null && iter.parent.right == iter) {
      iter = iter.parent;
    }
    return iter.parent;
  }

  @Data
  @Builder
  static class TreeNode {
    int val;
    TreeNode left, right, parent;
  }
}
