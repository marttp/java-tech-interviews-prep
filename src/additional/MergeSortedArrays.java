package additional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

  public List<Integer> mergeSortedArray(List<List<Integer>> arrays) {
    PriorityQueue<Element> pq = new PriorityQueue<>(
        Comparator.comparingInt(e -> arrays.get(e.listIndex).get(e.elementIndex))
    );
    for (int i = 0; i < arrays.size(); i++) {
      if (arrays.get(i) != null) {
        pq.add(new Element(i, 0));
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      Element currElem = pq.poll();
      result.add(arrays.get(currElem.listIndex).get(currElem.elementIndex));
      int nextIndex = currElem.elementIndex + 1;
      if (nextIndex < arrays.get(currElem.listIndex).size()) {
        currElem.elementIndex++;
        pq.add(currElem);
      }
    }
    return result;
  }

  private static class Element {

    public int listIndex;
    public int elementIndex;

    public Element(int listIndex, int elementIndex) {
      this.listIndex = listIndex;
      this.elementIndex = elementIndex;
    }
  }
}
