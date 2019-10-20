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
    if (root == null) return 0;
    return helpEvaluate(root);
  }

  private double helpEvaluate(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      return Double.parseDouble(root.value);
    } else {
      GroupNode node = (GroupNode) root;
      if (root.value.equals("+"))
        return helpEvaluate(node.left) + helpEvaluate(node.right);
      else if (root.value.equals("-")) {
        return helpEvaluate(node.left) - helpEvaluate(node.right);
      } else if (root.value.equals("*")) {
        return helpEvaluate(node.left) * helpEvaluate(node.right);
      } else {
        double right = helpEvaluate(node.right);
        if (right == 0) {
          throw new IllegalArgumentException("The dividend cannot be 0");
        }
        return helpEvaluate(node.left) / right;
      }
    }
  }

  @Override
  public String infix() {
    if (root == null) return "";
    return inOrderTraverse(root);
  }

  private String inOrderTraverse(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      return root.value;
    } else {
      StringBuilder sb = new StringBuilder();
      GroupNode node = (GroupNode) root;
      sb.append("(").append(inOrderTraverse(node.left)).append(root.value).append(inOrderTraverse(node.right)).append(")");
      return String.valueOf(sb);
    }
  }

  @Override
  public String schemeExpression() {
    if (root == null) return "";
    return preOrderTraverse(root);
  }

  private String preOrderTraverse(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      return root.value;
    } else {
      StringBuilder sb = new StringBuilder();
      GroupNode node = (GroupNode) root;
      sb.append("(").append(root.value).append(preOrderTraverse(node.left)).append(preOrderTraverse(node.right)).append(")");
      return String.valueOf(sb);
    }
  }
}
