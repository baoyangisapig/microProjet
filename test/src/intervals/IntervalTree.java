package intervals;

import java.util.Stack;

import generictree.AbstractTreeNode;
import generictree.GroupNode;
import generictree.LeafNode;

/**
 * The class represents a interval tree with all the intervals and operations.
 */
public class IntervalTree implements Intervals {


  private static final String INVALID_INTERVAL_EXPRESSION = "Invalid interval expression.";

  AbstractTreeNode<String> root;

  /**
   * The constructor for IntervalTree.
   *
   * @param expression the String express the interval tree.
   * @throws IllegalArgumentException
   */
  public IntervalTree(String expression) throws IllegalArgumentException {
    if (expression == null || expression.trim().isEmpty()) {
      return;
    }
    String[] strs = expression.trim().split("\\s+");
    if (strs.length == 1) {
      String str = strs[0];
      if (!IntervalValidationUtil.isValidOperation(str)) {
        throw new IllegalArgumentException(INVALID_INTERVAL_EXPRESSION);
      }
      this.root = new LeafNode<>(str);
      return;
    }
    Stack<AbstractTreeNode<String>> stack = new Stack<>();
    for (int i = 0; i < strs.length; i++) {
      if (!IntervalValidationUtil.isValidTerm(strs[i])) {
        throw new IllegalArgumentException(INVALID_INTERVAL_EXPRESSION);
      }
      if (IntervalValidationUtil.isValidOperation(strs[i])) {
        stack.push(new LeafNode<>(strs[i]));
      } else {
        GroupNode<String> curRoot = new GroupNode<>(strs[i]);
        if (stack.size() < 2) {
          throw new IllegalArgumentException(INVALID_INTERVAL_EXPRESSION);
        }
        curRoot.right = stack.pop();
        curRoot.left = stack.pop();
        stack.push(curRoot);
        this.root = curRoot;
      }
    }
    if (stack.size() > 1) {
      throw new IllegalArgumentException(INVALID_INTERVAL_EXPRESSION);
    }
  }


  @Override
  public Interval evaluate() {
    if (root == null) return null;
    return helpEvaluate(root);
  }

  private Interval helpEvaluate(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      String[] times = root.value.split(",");
      int start = Integer.parseInt(times[0]);
      int end = Integer.parseInt(times[1]);
      return new Interval(start, end);
    } else {
      GroupNode node = (GroupNode) root;
      if (root.value.equals("U")) {
        return helpEvaluate(node.left).union(helpEvaluate(node.right));
      } else {
        return helpEvaluate(node.left).intersect(helpEvaluate(node.right));
      }
    }
  }
}
