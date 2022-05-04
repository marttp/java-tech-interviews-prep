package lc.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utility.GenerateExample;

public class MakingFileNamesUnique_1487 implements GenerateExample {

  public String[] getFolderNames(String[] names) {
    if (names == null || names.length == 0) {
      return names;
    }
    Map<String, Integer> counterMap = new HashMap<>();
    for (int i = 0; i < names.length; i++) {
      int prefixCount = counterMap.getOrDefault(names[i], 0);
      if (prefixCount != 0) {
        // hold temporary text, so we can use it to create new text string
        String tmpFolderName = names[i];
        // We will us names[i] itself to store the data, if valid, will pass through
        // If invalid, will still use the same index until prefixCount are not contains
        // in counter map
        while (counterMap.getOrDefault(names[i], 0) != 0) { // use same as prefixCount condition at above
          // If it drop to zero zone => they don't have key with same prefix (combined counter)
          StringBuilder sb = new StringBuilder(tmpFolderName).append('(')
              .append(prefixCount)
              .append(')');
          names[i] = sb.toString();
          prefixCount++;
        }
        counterMap.put(tmpFolderName, prefixCount);
      }
      // Put this as a folder name itself
      // in case in array we have [fifo, fifo(1), fifo, fifo(1)]
      // the last result should be [fifo, fifo(1), fifo(2), fifo(1)(2)]
      counterMap.put(names[i], 1);
    }
    return names;
  }

  @Override
  public void example() {
    List<String> testData = List.of("fifo", "fifo(1)", "fifo", "fifo(1)");
    String[] result = getFolderNames(testData.toArray(new String[0]));
    System.out.println("Result: " + Arrays.toString(result)); // [fifo, fifo(1), fifo(2), fifo(1)(2)]
  }
}
