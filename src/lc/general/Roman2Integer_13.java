package lc.general;

import java.util.Map;

public class Roman2Integer_13 {

  private static final Map<Character, Integer> SYMBOL = Map.of(
      'I', 1,
      'V', 5,
      'X', 10,
      'L', 50,
      'C', 100,
      'D', 500,
      'M', 1000
  );

  public int romanToInt(String s) {
    int value = 0;
    int i = s.length() - 1;
    value += SYMBOL.get(s.charAt(i--));
    while (i >= 0) {
      if (SYMBOL.get(s.charAt(i)) < SYMBOL.get(s.charAt(i + 1))) {
        value -= SYMBOL.get(s.charAt(i));
      } else {
        value += SYMBOL.get(s.charAt(i));
      }
      i--;
    }
    return value;
  }
}
