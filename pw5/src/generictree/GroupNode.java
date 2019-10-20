package generictree;

public class GroupNode<T> extends AbstractTreeNode<T> {
  private TreeNode<T> left;
  private TreeNode<T> right;

  private TreeNode<T> getLeft() {
    return left;
  }

  private TreeNode<T> getRight() {
    return right;
  }

  @Override
  public void addChild(TreeNode<T> child) throws IllegalArgumentException {
    if (child == null || (getLeft() != null && getRight() != null)) {
      throw new IllegalArgumentException("Invalid Expression!");
    }
    if (left != null) {
      left = child;
    } else {
      right = child;
    }
    return;
  }
}
