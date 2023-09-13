package problems;

public class Q0011ContainerWithMostWater {

  public int maxArea(int[] height) {
    // FIXME O(n^2) complexity, no good.
    int max = 0;
    for (int l = 0; l < height.length - 1; l++) {
      if ((height.length - l) * height[l] <= max) continue;
      for (int r = l + 1; r < height.length; r++) {
        int current = (r - l) * Math.min(height[l], height[r]);
        if (current > max) max = current;
      }
    }
    return max;
  }
}
