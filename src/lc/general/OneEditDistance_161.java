package lc.general;

public class OneEditDistance_161 {

  public boolean isOneEditDistance(String s, String t) {
    if (s.length() == t.length()) {
      return oneEditReplace(s, t);
    } else if (s.length() + 1 == t.length()) {
      return oneEditInsert(s, t);
    } else if (s.length() - 1 == t.length()) {
      return oneEditInsert(t, s);
    }
    return false;
  }

  private boolean oneEditReplace(String s1, String s2) {
    boolean isOneDiff = false;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (isOneDiff) {
          return false;
        }
        isOneDiff = true;
      }
    }
    return isOneDiff;
  }

  boolean oneEditInsert(String s1, String s2) {
    int i1 = 0;
    int i2 = 0;
    while (i1 < s1.length() && i2 < s2.length()) {
      if (s1.charAt(i1) != s2.charAt(i2)) {
        if (i1 != i2) {
          return false;
        }
      } else {
        i1++;
      }
      i2++;
    }
    return true;
  }
}
