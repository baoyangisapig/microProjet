package intervals;

import org.junit.Assert;
import org.junit.Test;


/**
 * The class represents the Junit Test for Interval.
 */
public class IntervalTreeTest {

  @Test

  public void evaluate() {
    IntervalTree tree = new IntervalTree("1,4 2,5 U");
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

}