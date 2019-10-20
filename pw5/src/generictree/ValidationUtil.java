package generictree;

import java.util.HashSet;
import java.util.Set;

/**
 * Check validation of input of the {@link expression.ExpressionTree}.
 */
public class ValidationUtil {

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
}
