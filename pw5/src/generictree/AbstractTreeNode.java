package generictree;

public abstract class AbstractTreeNode<T> {
  public T value;

  public AbstractTreeNode(T value) {
    this.value = value;
  }
}
