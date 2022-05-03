package lc.general;

import java.util.Arrays;

public class NumberDifferentIntegersInString_1805 {

  public int numDifferentInteger(String word) {
    String[] wordSplit = word.replaceAll("[a-z]+", " ")
        .split("\\s+");
    return (int) Arrays.stream(wordSplit)
        .filter(t -> !t.isEmpty())
        // replace prefix zero with empty string
        .map(t -> t.replaceFirst("^0+", ""))
        .distinct()
        .count();
  }
}
