package intervals;

public class IntervalValidationUtil {

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

  public static boolean isValidOperator(String str) {
    return str.trim().equals("U") || str.trim().equals("I");
  }

  public static boolean isValidTerm(String str) {
    return isValidOperation(str) || isValidOperator(str);
  }
}
