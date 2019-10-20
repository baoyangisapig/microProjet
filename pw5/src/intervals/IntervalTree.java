package intervals;

import java.util.Stack;

import generictree.AbstractTreeNode;
import generictree.GroupNode;
import generictree.LeafNode;
import generictree.ValidationUtil;

public class IntervalTree implements Intervals {

  private static final String INVALID_INTERVAL_EXPRESSION = "Invalid interval expression.";

  AbstractTreeNode<String> root;

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
    return null;
  }
}
