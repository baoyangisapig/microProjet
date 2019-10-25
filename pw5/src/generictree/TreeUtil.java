package generictree;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/**
 * Check validation of input of the {@link expression.ExpressionTree}.
 */
public class TreeUtil {

  /**
   * Set of operators supported by the expressionTree.
   */
  static Set<String> operators = new HashSet<>();

  static {
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
  }

  /**
   * Return if the input is valid.
   *
   * @param str Current term of the expression.
   * @return Return true if valid, false if not valid.
   * @throws NumberFormatException If the input is invalid, throw this exception.
   */
  public static boolean isValid(String str) throws NumberFormatException {
    if (isOperator(str)) {
      return true;
    }
    Double.parseDouble(str);
    return true;
  }

  /**
   * Judge if this term is an operator +, -, * or /.
   *
   * @param str Current term of the expression.
   * @return If current term is an operator among +,-,* and /, return true, otherwise return false.
   */
  public static boolean isOperator(String str) {
    return operators.contains(str);
  }

  /**
   * Judge if this term is a valid numeric term.
   *
   * @param str Current term of the expression.
   * @return If current term is a valid numeric term, return true, else return false.
   */
  public static boolean isDouble(String str) {
    return !isOperator(str);
  }

  /**
   * The method is to print a tree to show its structure.
   *
   * @param root The root of the tree.
   * @return The structure of the tree in a String format.
   */
  public static Pair<String, Integer> helpText(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      return new Pair<>(root.value, 0);
    }
    GroupNode cur = (GroupNode) root;
    Pair<String, Integer> leftPair = transformleft(helpText(cur.left));
    Pair<String, Integer> rightPair = transformRight(helpText(cur.right));
    StringBuilder tree = new StringBuilder();
    tree.append(root.value).append("\n|\n|\n|___").append(leftPair.getKey());
    for (int i = 1; i <= 2; i++) {
      tree.append("\n|");
    }
    tree.append("___").append(rightPair.getKey());
    return new Pair<>(String.valueOf(tree), 5 + leftPair.getValue() + rightPair.getValue());
  }

  private static Pair<String, Integer> transformleft(Pair<String, Integer> pair) {
    String tree = pair.getKey();
    String newTree = tree.replace("\n", "\n|   ");
    return new Pair<>(newTree, pair.getValue());
  }

  private static Pair<String, Integer> transformRight(Pair<String, Integer> pair) {
    String tree = pair.getKey();
    String newTree = tree.replace("\n", "\n   ");
    return new Pair<>(newTree, pair.getValue());
  }
}
