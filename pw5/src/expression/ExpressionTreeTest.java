package expression;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTreeTest {

  private static String FAIL_INFO = "Should have thrown an exception!";

  @Test
  public void constructor() throws Exception {
    ExpressionTree tree = new ExpressionTree("2");
    tree = new ExpressionTree("1 2 +");
    tree = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    tree = new ExpressionTree("3 2 + 65.12 -");
    tree = new ExpressionTree("3 5 + 4 -");
    tree = new ExpressionTree("3 5 / 4 -");
    try {
      tree = new ExpressionTree("+");
      fail(FAIL_INFO);
    } catch (IllegalArgumentException e) {
      //Do nothing here.
    }
    try {
      tree = new ExpressionTree("&");
      fail(FAIL_INFO);
    } catch (IllegalArgumentException e) {
      //Do nothing here.
    }
    try {
      tree = new ExpressionTree(" 3.5 +   2");
      fail(FAIL_INFO);
    } catch (IllegalArgumentException e) {
      //Do nothing here.
    }
    try {
      tree = new ExpressionTree(" 3.5 2.7 9.7 -");
      fail(FAIL_INFO);
    } catch (IllegalArgumentException e) {
      //Do nothing here.
    }
  }

  @org.junit.Test
  public void evaluate() {

  }

  @org.junit.Test
  public void infix() {
  }

  @org.junit.Test
  public void schemeExpression() {
  }
}