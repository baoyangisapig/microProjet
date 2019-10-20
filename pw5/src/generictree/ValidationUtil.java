package generictree;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {

  static Set<String> operators = new HashSet<>();

  static {
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
  }

  public static boolean isValid(String str) throws NumberFormatException {
    if (isOperator(str)) {
      return true;
    }
    Double.parseDouble(str);
    return true;
  }

  public static boolean isOperator(String str) {
    return operators.contains(str);
  }

  public static boolean isDouble(String str) {
    return !isOperator(str);
  }
}
