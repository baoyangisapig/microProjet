import org.junit.Assert;
import org.junit.Test;

import intervals.Interval;
import intervals.IntervalTree;


/**
 * The class represents the Junit Test for Interval.
 */
public class IntervalTreeTest {

  @Test
  public void evaluate() {
    IntervalTree tree11 = new IntervalTree("");
    IntervalTree tree = new IntervalTree(" 1,2 3,4 4,6 U 3,5 I U ");
    Interval interval = new Interval(1, 5);
    Assert.assertTrue(tree.evaluate().toString().equals(interval.toString()));
    IntervalTree tree1 = new IntervalTree("1,4");
    Interval interval1 = new Interval(1, 4);
    Assert.assertTrue(tree1.evaluate().toString().equals(interval1.toString()));
    IntervalTree tree2 = new IntervalTree("1,4 2,5 I");
    Interval interval2 = new Interval(2, 4);
    Assert.assertTrue(tree2.evaluate().toString().equals(interval2.toString()));
    IntervalTree tree3 = new IntervalTree("");
    Assert.assertNull(tree3.evaluate());
    IntervalTree tree4 = new IntervalTree("1,6 2,5 I 1,6 1,2 3,4 4,6 U 3,5 I U I U");
  }

  @Test
  public void constructorTest() {
    IntervalTree tree = new IntervalTree("1,4 2,5 U");
    tree = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    tree = new IntervalTree("3,7 2,6 4,10 I U");
    tree = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    tree = new IntervalTree("1,2");
    try {
      tree = new IntervalTree("1 2");
    } catch (IllegalArgumentException e) {
      Assert.assertTrue(e.getMessage().equals("Invalid interval expression."));
    }
    try {
      tree = new IntervalTree("1 U 2");
    } catch (IllegalArgumentException e) {
      Assert.assertTrue(e.getMessage().equals("Invalid interval expression."));
    }
    try {
      tree = new IntervalTree(" ");
    } catch (IllegalArgumentException e) {
      Assert.assertTrue(e.getMessage().equals("Invalid interval expression."));
    }
    tree = new IntervalTree("");
  }

  @Test
  public void textTree() {
    IntervalTree tree = new IntervalTree("1,2 3,4 4,6 U 3,5 I U ");
    Assert.assertTrue(tree.textTree().equals("U\n" +
            "|\n" +
            "|\n" +
            "|___1,2\n" +
            "|\n" +
            "|___I\n" +
            "   |\n" +
            "   |\n" +
            "   |___U\n" +
            "   |   |\n" +
            "   |   |\n" +
            "   |   |___3,4\n" +
            "   |   |\n" +
            "   |   |___4,6\n" +
            "   |\n" +
            "   |___3,5"));
    IntervalTree tree1 = new IntervalTree("");
    Assert.assertTrue(tree1.textTree().equals(""));
    IntervalTree tree2 = new IntervalTree("1,2 2,5 U");
    Assert.assertTrue(tree2.textTree().equals("U\n" +
            "|\n" +
            "|\n" +
            "|___1,2\n" +
            "|\n" +
            "|___2,5"));
    IntervalTree tree3 = new IntervalTree("1,2");
    Assert.assertTrue(tree3.textTree().equals("1,2"));
  }

}