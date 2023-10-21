package problems.Q0001_Q0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0006ZigzagConversion {

  public String convert(String s, int numRows) {
    if (numRows < 1) throw new IllegalArgumentException();
    if (numRows == 1) return s;

    StringBuilder builder = new StringBuilder();
    for (int row = 0; row < numRows; row++) {
      if (row == s.length()) break;

      int mod = row % (numRows - 1);
      int modComplement = numRows - 1 - mod;
      if (mod == 0) mod = modComplement; // first and last row has the same distance
      // offset for next indices
      Map<Integer, Integer> mapOfOffset = new HashMap<>();
      mapOfOffset.put(0, mod * 2);
      mapOfOffset.put(1, modComplement * 2);

      // getting the indices and append char
      int next = row;
      int alternating = 1;
      while (next < s.length()) {
        builder.append(s.charAt(next));
        next = next + mapOfOffset.get(alternating);
        alternating = (alternating + 1) % 2;
      }
    }
    return builder.toString();
  }

  /**
   * @param row index from 0, in the zigzagged form.
   * @param numRows total number of row, given by question.
   * @param MAX_LENGTH length or size of the string.
   * @return all indices in the original string, that will be written in row.
   */
  public List<Integer> getIndicesAtRow(int row, int numRows, int MAX_LENGTH) {
    List<Integer> result = new ArrayList<>();
    result.add(row); // FIXME numRows might be larger than MAX_LENGTH,
    // introducing index out of bound here

    // offset for next indices
    int mod = row % (numRows - 1);
    int modComplement = numRows - 1 - mod;
    if (mod == 0) mod = modComplement; // first and last row has the same distance
    mod *= 2;
    modComplement *= 2;

    Map<Integer, Integer> mapOfOffset = new HashMap<>();
    mapOfOffset.put(0, mod);
    mapOfOffset.put(1, modComplement);

    // getting the indices
    int prev = row;
    int alternating = 1;
    while (true) {
      int next = prev + mapOfOffset.get(alternating);
      if (next >= MAX_LENGTH) break;
      result.add(next);

      prev = next;
      alternating = (alternating + 1) % 2;
    }
    return result;
  }
}
