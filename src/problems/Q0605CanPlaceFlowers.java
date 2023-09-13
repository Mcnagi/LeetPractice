package problems;

public class Q0605CanPlaceFlowers {
  // 1 0 0 0 0 0 1
  // 0 0 1
  // 0 0 0 1
  // 0 0 0 0 1
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed.length == 1 && n == 1) return flowerbed[0] == 0;
    if (flowerbed.length == n) return false;
    int i = 0;
    while (i < flowerbed.length && flowerbed[i] == 0) {
      i++;
    }
    int count = i / 2;
    if (i == flowerbed.length) {
      count += i % 2;
      return count >= n;
    }
    int prev = i;
    for (; i < flowerbed.length; i++) {
      if (flowerbed[i] == 1) {
        int tmp = i - prev - 1 - 3;
        if (tmp >= 0) {
          count += 1 + tmp / 2;
        }
        prev = i;
      }
    }
    count += (flowerbed.length - prev - 1) / 2;
    return count >= n;
  }
}
