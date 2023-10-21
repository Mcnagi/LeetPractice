package problems;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0026RemoveDuplicatesFromSortedArray;

public class Q0026Test {

  public boolean arrayEqual(int[] expectedArray, int[] actual) {
    for (int i = 0; i < expectedArray.length; i++) {
      if (expectedArray[i] != actual[i]) return false;
    }
    return true;
  }

  public void test(int expectedK, int[] expectedArray, int[] input) {
    var q = new Q0026RemoveDuplicatesFromSortedArray(input);
    Assertions.assertEquals(
        expectedK,
        q.removeDuplicates(),
        String.format("Expect to have %s with input: %s", expectedK, input));

    Assertions.assertTrue(
        arrayEqual(expectedArray, q.array),
        String.format(
            "Expect to get: %s, but got: %s",
            Arrays.toString(expectedArray), Arrays.toString(q.array)));
  }

  @Test
  public void testSimple() {
    test(2, new int[] {1, 2}, new int[] {1, 1, 2});
  }

  @Test
  public void testMedian() {
    test(5, new int[] {0, 1, 2, 3, 4}, new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    int[] tmpUnique = new int[50];
    for (int i = 0; i < tmpUnique.length; i++) {
      tmpUnique[i] = i - 20;
    }
    test(tmpUnique.length, tmpUnique, tmpUnique);
  }

  //    @Test
  //    public void testHard() {
  //        test(2, new int[]{1,2}, new int[]{1,1,2});
  //    }
}
