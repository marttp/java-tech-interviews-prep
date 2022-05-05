package lc.general;

import static constant.StringConstant.LOWERCASE_AMOUNT;

public class RansomNote_383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] count = new int[LOWERCASE_AMOUNT];
    for (char c : magazine.toCharArray()) {
      count[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (count[c - 'a'] == 0) {
        return false;
      }
      count[c - 'a']--;
    }
    return true;
  }
}
