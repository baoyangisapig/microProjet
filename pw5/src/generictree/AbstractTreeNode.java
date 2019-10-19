package generictree;

public abstract class AbstractTreeNode<T> implements TreeNode<T>{
  private TreeNode<T> value;

  public TreeNode<T> getValue() {
    return value;
  }

  @Override
  public TreeNode<T> addChild(TreeNode<T> child) {
    return null;
  }
}
