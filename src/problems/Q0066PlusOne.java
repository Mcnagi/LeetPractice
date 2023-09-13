package problems;

public class Q0066PlusOne {
  public int[] plusOne(int[] digits) {
    int carryOn = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int tmp = carryOn + digits[i];
      digits[i] = tmp % 10;
      carryOn = tmp / 10;
      if (carryOn == 0) break;
    }
    if (carryOn == 1) {
      int[] tmpArray = new int[digits.length + 1];
      System.arraycopy(digits, 0, tmpArray, 1, digits.length);
      tmpArray[0] = 1;
      digits = tmpArray;
    }
    return digits;
  }
}
