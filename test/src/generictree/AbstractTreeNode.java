package generictree;

/**
 * Abstract node of the Expression Tree.
 *
 * @param <T> Type of value of the node.
 */
public abstract class AbstractTreeNode<T> {
  /**
   * Value of current Node.
   */
  public T value;

  /**
   * Constructor of current node.
   *
   * @param value Value of current node.
   */
  public AbstractTreeNode(T value) {
    this.value = value;
  }
}
