package genericNode;

import java.util.HashSet;
import java.util.Set;

import genericNode.AbstractTreeNode;
import genericNode.GroupNode;
import genericNode.LeafNode;

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
  public static String helpText(AbstractTreeNode<String> root) {
    if (root.getClass().getName().equals(LeafNode.class.getName())) {
      return root.value;
    }
    GroupNode cur = (GroupNode) root;
    String leftPair = helpText(cur.left).replace("\n", "\n|   ");
    String rightPair = helpText(cur.right).replace("\n", "\n   ");
    StringBuilder tree = new StringBuilder();
    tree.append(root.value).append("\n|\n|\n|___").append(leftPair);
    for (int i = 1; i <= 2; i++) {
      tree.append("\n|");
    }
    tree.append("___").append(rightPair);
    return String.valueOf(tree);
  }

}
