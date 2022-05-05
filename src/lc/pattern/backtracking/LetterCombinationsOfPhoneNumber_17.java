package lc.pattern.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber_17 {

  private static final String[] NUMPAD = {"", "", "abc", "def", "ghi",
      "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    backtracking(digits, 0, result, new StringBuilder());
    return result;
  }

  private void backtracking(String digits, int currentIndex, List<String> result,
      StringBuilder sb) {
    if (currentIndex == digits.length()) {
      result.add(sb.toString());
      return;
    }
    int targetIndex = Character.getNumericValue(digits.charAt(currentIndex));
    String possibleStr = NUMPAD[targetIndex];
    for (char c : possibleStr.toCharArray()) {
      sb.append(c);
      backtracking(digits, currentIndex + 1, result, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
