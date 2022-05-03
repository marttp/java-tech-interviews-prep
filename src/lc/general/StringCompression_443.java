package lc.general;

public class StringCompression_443 {

  public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
      return 0;
    }
    int writeIndex = 0;
    int counter = 1;
    for (int i = 0; i < chars.length; i++) {
      while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
        counter++;
        i++;
      }
      // drop to this zone when next element not match, or we on last element
      chars[writeIndex++] = chars[i];
      if (counter != 1) {
        String numTxt = String.valueOf(counter);
        for (char c : numTxt.toCharArray()) {
          chars[writeIndex++] = c;
        }
      }
      // Reset
      counter = 1;
    }
    return writeIndex;
  }
}
