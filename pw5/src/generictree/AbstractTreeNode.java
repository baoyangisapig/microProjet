package generictree;

public abstract class AbstractTreeNode<T> implements TreeNode<T> {
  T value;

  public T getValue() {
    return value;
  }

  @Override
  public void addChild(TreeNode<T> child) throws IllegalArgumentException {

  }
}
