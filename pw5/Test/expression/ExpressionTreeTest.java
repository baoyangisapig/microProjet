package expression;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * The class represents the Junit Test for ExpressionTree.
 */
public class ExpressionTreeTest {

  private static String FAIL_INFO = "Should have thrown an exception!";


  @Test
  public void constructor() throws Exception {
    ExpressionTree tree = new ExpressionTree("2");
    tree = new ExpressionTree("1 2 +");
    tree = new ExpressionTree("");
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

  @Test
  public void evaluate() {
    ExpressionTree expressionTree = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    Assert.assertEquals(expressionTree.evaluate(), 1.98, 0.1);
    ExpressionTree expressionTree1 = new ExpressionTree("3 5 + 4 -");
    Assert.assertEquals(expressionTree1.evaluate(), 4, 0.1);
    ExpressionTree expressionTree2 = new ExpressionTree("3");
    Assert.assertEquals(expressionTree2.evaluate(), 3, 0.1);
    ExpressionTree expressionTree3 = new ExpressionTree("");
    Assert.assertEquals(expressionTree3.evaluate(), 0, 0.1);
  }

  @Test
  public void infix() {
    ExpressionTree expressionTree = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    Assert.assertTrue(expressionTree.infix().equals("((1.2*5.4)+-4.5)"));
    ExpressionTree expressionTree2 = new ExpressionTree("3");
    Assert.assertTrue(expressionTree2.infix().equals("3"));
    ExpressionTree expressionTree3 = new ExpressionTree("");
    Assert.assertTrue(expressionTree3.infix().equals(""));
  }

  @Test
  public void schemeExpression() {
    ExpressionTree expressionTree = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    Assert.assertTrue(expressionTree.schemeExpression().equals("(+(*1.25.4)-4.5)"));
    ExpressionTree expressionTree2 = new ExpressionTree("3");
    Assert.assertTrue(expressionTree2.infix().equals("3"));
    ExpressionTree expressionTree3 = new ExpressionTree("");
    Assert.assertTrue(expressionTree3.infix().equals(""));
  }
}
