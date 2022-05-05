package lc.pattern.slidingwindow;

import static constant.StringConstant.LOWERCASE_AMOUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import utility.Util;

public class FindAllAnagramsInString_438 {

  public List<Integer> findAnagrams(String s, String p) {
    if (p.length() > s.length()) {
      return Collections.emptyList();
    }
    // p => pattern
    int[] pCount = new int[LOWERCASE_AMOUNT];
    int[] sCount = new int[LOWERCASE_AMOUNT];

    for (int i = 0; i < p.length(); i++) {
      pCount[Util.getLowercaseIndex(p.charAt(i))]++;
      sCount[Util.getLowercaseIndex(s.charAt(i))]++;
    }

    List<Integer> result = new ArrayList<>();
    if (s.length() == p.length() && Arrays.equals(pCount, sCount)) {
      result.add(0);
      return result;
    }
    int i;
    for (i = 0; i < s.length() - p.length(); i++) {
      if (Arrays.equals(pCount, sCount)) {
        result.add(i);
      }
      // Remove from start of p range
      sCount[Util.getLowercaseIndex(s.charAt(i))]--;
      // Add next character and keep p range
      sCount[Util.getLowercaseIndex(s.charAt(i + p.length()))]++;
    }
    if (Arrays.equals(pCount, sCount)) {
      result.add(i);
    }
    return result;
  }
}
