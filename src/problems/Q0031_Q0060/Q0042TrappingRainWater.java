package problems.Q0031_Q0060;

public class Q0042TrappingRainWater {
  int leftIndex;
  int rightIndex;
  int[] height;
  int result = 0;

  public int trap(int[] height) {
    this.height = height;
    leftIndex = 0;
    rightIndex = this.height.length - 1;
    while (leftIndex < rightIndex) trapped();
    return result;
  }

  public void trapped() {
    int index = leftIndex;
    while (index < rightIndex && height[index] >= height[leftIndex]) leftIndex = index++;
    index = rightIndex;
    while (index > leftIndex && height[index] >= height[rightIndex]) rightIndex = index--;

    if (leftIndex >= rightIndex) return;
    if (height[leftIndex] < height[rightIndex]) moveLeft();
    else if (height[leftIndex] > height[rightIndex]) moveRight();
    else {
      moveLeft();
      moveRight();
    }
  }

  public void moveLeft() {
    int index = leftIndex + 1;
    while (index < rightIndex && height[index] <= height[leftIndex]) {
      result += height[leftIndex] - height[index];
      index += 1;
    }
    leftIndex = index;
  }

  public void moveRight() {
    int index = rightIndex - 1;
    while (leftIndex < index && height[index] <= height[rightIndex]) {
      result += height[rightIndex] - height[index];
      index -= 1;
    }
    rightIndex = index;
  }
}
