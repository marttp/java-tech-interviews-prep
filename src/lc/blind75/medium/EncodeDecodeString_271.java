package lc.blind75.medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString_271 {

  private static class Codec {

    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for (String s : strs) {
        // Concat with some delimiter
        sb.append(s.length()).append('#').append(s);
      }
      return sb.toString();
    }

    public List<String> decode(String s) {
      List<String> result = new ArrayList<>();
      int i = 0;
      while (i < s.length()) {
        // Find next Delimiter
        int delimiter = s.indexOf('#', i);
        // cut string on part i to delimiter index
        int length = Integer.parseInt(s.substring(i, delimiter));
        // delimiter + length of word (like we do encode!)
        i = delimiter + length + 1;
        result.add(s.substring(delimiter + 1, i));
      }
      return result;
    }
  }
}
