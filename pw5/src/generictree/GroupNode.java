package generictree;

public class GroupNode<T> extends AbstractTreeNode<T> {
  public AbstractTreeNode<T> left;
  public AbstractTreeNode<T> right;

  public GroupNode(T value) {
    super(value);
  }
}
