package additional;

public class ArrayIndexEqualsValue {

  public int arrayIndexEqualsValue(int[] array) {
    // Array sorted => if not we can sort them but improve time complexity also
    // Return the minimum index where index equals value on that index
    int result = -1;
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int diff = mid - array[mid];
      if (diff == 0) {
        result = mid;
        right = mid - 1;
      } else if (diff < 0) {
        // It's mean => current of mid value is more than mid index
        right = mid - 1;
      } else {
        // so this one will take opposite side => mid - (-value)
        left = mid + 1;
      }
    }
    return result;
  }
}
