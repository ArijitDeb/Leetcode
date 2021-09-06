package practice.binarytree;

import java.util.List;

public interface BinaryTreeTraversal<T> {
  List<T> getTraversalOrder(BinaryTreeNode<T> treeNode);

  List<T> getTraversalOrderWithoutRecursion(BinaryTreeNode<T> treeNode);
}
