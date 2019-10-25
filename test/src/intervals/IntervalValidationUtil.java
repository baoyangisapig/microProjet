package intervals;

/**
 * The class represents the Util to validate the interval.
 */
public class IntervalValidationUtil {
  /**
   * Validate the operation in the interval expression.
   *
   * @param str The input String represents interval
   * @return Boolean value represents the result of validation
   * @throws NumberFormatException
   */
  public static boolean isValidOperation(String str) throws NumberFormatException {
    if (!str.contains(",")) {
      return false;
    }
    String[] strs = str.trim().split(",");
    if (strs.length != 2) return false;
    Integer.parseInt(strs[0]);
    Integer.parseInt(strs[1]);
    return true;
  }

  /**
   * Validate the operator in the interval expression.
   *
   * @param str The input String represents interval
   * @return Boolean value represents the result of validation
   */
  public static boolean isValidOperator(String str) {
    return str.trim().equals("U") || str.trim().equals("I");
  }

  /**
   * Validate the operator and the operation in the interval expression.
   *
   * @param str The input String represents interval.
   * @return Boolean value represents the result of validation.
   */
  public static boolean isValidTerm(String str) {
    return isValidOperation(str) || isValidOperator(str);
  }
}
