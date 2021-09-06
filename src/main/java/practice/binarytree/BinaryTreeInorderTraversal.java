package practice.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal implements BinaryTreeTraversal<Integer> {
  @Override
  public List<Integer> getTraversalOrder(BinaryTreeNode<Integer> treeNode) {
    List<Integer> result = new LinkedList<>();
    getInorderHelper(treeNode, result);
    return result;
  }

  private static void getInorderHelper(
      final BinaryTreeNode<Integer> treeNode, final List<Integer> result) {
    if (treeNode == null) {
      return;
    }
    if (treeNode.left != null) {
      getInorderHelper(treeNode.left, result);
    }
    result.add(treeNode.val);
    if (treeNode.right != null) {
      getInorderHelper(treeNode.right, result);
    }
  }

  @Override
  public List<Integer> getTraversalOrderWithoutRecursion(BinaryTreeNode<Integer> treeNode) {
    List<Integer> result = new LinkedList<>();
    Deque<BinaryTreeNode> stack = new ArrayDeque<>();
    BinaryTreeNode<Integer> cur = treeNode;

    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      result.add(cur.val);
      cur = cur.right;
    }
    return result;
  }
}
