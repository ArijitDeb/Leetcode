package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/** https://leetcode.com/problems/basic-calculator-ii/ */
public class BasicCalculator2 {

  public int calculate(String s) {
    Deque<Integer> nums = new ArrayDeque<>();
    char lastOperator = '+';

    int tempNum = 0;
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      } else if (Character.isDigit(c)) {
        tempNum = tempNum * 10 + (c - '0');
      } else {
        evalAndPush(nums, tempNum, lastOperator);
        tempNum = 0;
        lastOperator = c;
      }
    }
    evalAndPush(nums, tempNum, lastOperator);
    return nums.stream().reduce(0, Integer::sum).intValue();
  }

  private void evalAndPush(Deque<Integer> nums, int num, char op) {
    if (op == '+') {
      nums.push(num);
    } else if (op == '-') {
      nums.push(-num);
    } else if (op == '*') {
      nums.push(nums.pop() * num);
    } else if (op == '/') {
      nums.push(nums.pop() / num);
    }
  }
}
