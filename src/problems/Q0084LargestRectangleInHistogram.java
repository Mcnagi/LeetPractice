package problems;

public class Q0084LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    int max = 0;
    int len = heights.length;
    for (int i = 0; i < len; i++) {
      int height = heights[i];
      if (height * (len - i) <= max) continue;
      int j = i + 1;
      while (j < len && heights[j] >= heights[i]) j++;
      int currentMax = height * (j - i);
      while (j < len) {
        height = Math.min(height, heights[j]);
        if (height * (len - i) <= currentMax) break;
        int tmp = height * (j - i + 1);
        if (tmp > currentMax) currentMax = tmp;
        j++;
      }
      if (currentMax > max) max = currentMax;
    }
    return max;
  }
}
