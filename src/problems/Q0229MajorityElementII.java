package problems;

import java.util.ArrayList;
import java.util.List;

public class Q0229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>(2);
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        int xCount = 0, yCount = 0;
        for (int value : nums) {
            if (value == x) xCount += 1;
            else if (value == y) yCount += 1;
            else {
                if (xCount == 0) {
                    x = value;
                    xCount = 1;
                }
                else if (yCount == 0) {
                    y = value;
                    yCount = 1;
                }
                else {
                    xCount -= 1;
                    yCount -= 1;
                    if (xCount == 0) x = Integer.MAX_VALUE;
                    if (yCount == 0) y = Integer.MAX_VALUE;
                }
            }
        }

        if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) return result;
        xCount = 0;
        yCount = 0;
        for (int value : nums) {
            if (value == x) xCount += 1;
            else if (value == y) yCount += 1;
        }
        if (xCount > nums.length / 3) result.add(x);
        if (yCount > nums.length / 3) result.add(y);
        return result;
    }

}
