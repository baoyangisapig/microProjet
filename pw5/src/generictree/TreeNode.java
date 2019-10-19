package generictree;

public interface TreeNode<T> {
  /**
   * Add the given node as a child to a node in this tree identified by the predicate. If no node is
   * identified by the predicate the tree remains unchanged.
   *
   * @param child the node that must be added as a child
   * @return the resulting hierarchy starting at this node
   */
  void addChild(TreeNode<T> child) throws IllegalArgumentException;

}
