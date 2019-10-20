package expression;

import generictree.AbstractTreeNode;

public class ExpressionTree implements Expression {

  AbstractTreeNode<String> root;

  public ExpressionTree(String postfix) {
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
