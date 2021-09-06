package problems;

public class MinimumRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    boolean[] arr = new boolean[s.length()];
    int[] stack = new int[s.length()];
    int stackTopInd = -1;

    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        stack[++stackTopInd] = i;
      } else if (s.charAt(i) == ')') {
        if (stackTopInd >= 0) {
          arr[i] = true;
          arr[stack[stackTopInd--]] = true;
        }
      } else {
        arr[i] = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (arr[i]) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }
}
