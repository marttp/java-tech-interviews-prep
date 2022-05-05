package lc.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1_380 {

  private static class RandomizedSet {

    Random random;
    Map<Integer, Integer> mapValue; // k,v (num value, index)
    List<Integer> listData;

    public RandomizedSet() {
      random = new Random();
      mapValue = new HashMap<>();
      listData = new ArrayList<>();
    }

    public boolean insert(int val) {
      if (mapValue.containsKey(val)) {
        return false;
      }
      mapValue.put(val, listData.size());
      listData.add(listData.size(), val);
      return true;
    }

    public boolean remove(int val) {
      if (!mapValue.containsKey(val)) {
        return false;
      }
      int lastIndex = listData.size() - 1;
      int lastElement = listData.get(lastIndex);
      // Manage to swap data from last element to expect delete element
      int deleteIndex = mapValue.get(val);
      listData.set(deleteIndex, lastElement);
      mapValue.put(lastElement, deleteIndex);
      // Remove Last Element
      mapValue.remove(val);
      listData.remove(listData.size() - 1);
      return true;
    }

    public int getRandom() {
      return listData.get(random.nextInt(listData.size()));
    }
  }
}
