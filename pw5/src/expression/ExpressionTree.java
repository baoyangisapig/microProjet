package expression;

import java.util.Stack;

import generictree.AbstractTreeNode;
import generictree.GroupNode;
import generictree.LeafNode;
import generictree.ValidationUtil;

public class ExpressionTree implements Expression {

  AbstractTreeNode<String> root;

  private static final String INVALID_EXPRESSION = "Invalid Expression!";

  public ExpressionTree(String postfix) throws IllegalArgumentException {
    String[] strs = postfix.trim().split("\\s+");
    Stack<AbstractTreeNode<String>> stack = new Stack<>();
    for (int i = 0; i < strs.length; i++) {
      if (!ValidationUtil.isValid(strs[i])) {
        throw new IllegalArgumentException(INVALID_EXPRESSION);
      }
      if (ValidationUtil.isDouble(strs[i])) {
        stack.push(new LeafNode(strs[i]));
      } else {
        GroupNode<String> curRoot = new GroupNode<>(strs[i]);
        if (stack.size() < 2) {
          throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
        curRoot.right = stack.pop();
        curRoot.left = stack.pop();
        stack.push(curRoot);
        this.root = curRoot;
      }
    }
  }

  @Override
  public double evaluate() {
    return 0;
  }

  @Override
  public String infix() {
    return null;
  }

  @Override
  public String schemeExpression() {
    return null;
  }
}
