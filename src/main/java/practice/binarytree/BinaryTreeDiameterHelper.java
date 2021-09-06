package practice.binarytree;

import java.util.stream.IntStream;

public class BinaryTreeDiameterHelper {
  public static int getDiameter(final BinaryTreeNode node) {
    return getHeightAndDiameter(node).diameter;
  }

  private static HeightAndDiameter getHeightAndDiameter(final BinaryTreeNode node) {
    if (node == null) {
      return new HeightAndDiameter(0, 0);
    }
    HeightAndDiameter leftHeightAndDiameter = getHeightAndDiameter(node.left);
    HeightAndDiameter rightHeightAndDiameter = getHeightAndDiameter(node.right);

    int height = 1 + Math.max(leftHeightAndDiameter.height, rightHeightAndDiameter.height);
    int diameter =
        IntStream.of(
                leftHeightAndDiameter.diameter,
                rightHeightAndDiameter.diameter,
                leftHeightAndDiameter.height + rightHeightAndDiameter.height)
            .max()
            .getAsInt();
    return new HeightAndDiameter(height, diameter);
  }

  private static class HeightAndDiameter {
    int height, diameter;

    public HeightAndDiameter(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }
}
