package lc.blind75.medium;

import java.util.List;

public class WordBreak_139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] table = new boolean[s.length() + 1];
    table[0] = true;
    for (int i = 0; i <= table.length; i++) {
      if (table[i]) {
        for (String word : wordDict) {
          int maxIndex = i + word.length();
          if (maxIndex <= s.length() && s.substring(i, maxIndex).equals(word)) {
            table[maxIndex] = true;
          }
        }
      }
    }
    return table[s.length()];
  }
}
