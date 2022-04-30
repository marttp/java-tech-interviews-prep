package lc.blind75;

public class ContainerWithMostWater_11 {

  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int max = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int width = right - left;
      int area = width;
      if (height[left] < height[right]) {
        area *= height[left];
        left++;
      } else {
        area *= height[right];
        right--;
      }
      max = Integer.max(max, area);
    }

    return max;
  }
}
