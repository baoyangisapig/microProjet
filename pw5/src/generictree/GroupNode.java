package generictree;

/**
 * Group node for the expression. Value of group node could only be an operator but not a numeric
 * term. A group node must have a leftNode and a rightNode, which must both be numeric term.
 *
 * @param <T> Type of the value stored in current node.
 */
public class GroupNode<T> extends AbstractTreeNode<T> {
  /**
   * Left child node of current group node. It could be a numeric term or another operator term.
   */
  public AbstractTreeNode<T> left;

  /**
   * Right child node of current group node. It could be a numeric term or another operator term.
   */
  public AbstractTreeNode<T> right;

  /**
   * Counstructor of group node.
   *
   * @param value Value of current group node.
   */
  public GroupNode(T value) {
    super(value);
  }
}
