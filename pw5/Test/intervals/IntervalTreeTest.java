package intervals;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalTreeTest {

  @Test
  public void constructorTest() {
    IntervalTree tree = new IntervalTree("1,4 2,5 U");
    tree = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    tree = new IntervalTree("3,7 2,6 4,10 I U");
    tree = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    int k = 0;
  }

  @Test
  public void evaluate() {
  }
}