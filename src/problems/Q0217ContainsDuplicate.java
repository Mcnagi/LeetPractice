package problems;

import java.util.HashSet;
import java.util.Set;

public class Q0217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int value : nums) {
            if (unique.contains(value)) return true;
            unique.add(value);
        }
        return false;
    }
}
