package problems;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q0217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>(nums.length);
        for (int value : nums) {
            if (!unique.add(value)) return true;
        }
        return false;
    }

    //59 ms
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> unique = new TreeSet<>();
//        for (int value : nums) {
//            if (unique.contains(value)) return true;
//            unique.add(value);
//        }
//        return false;
//    }

    // 21ms lgN + N
//    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) return true;
//        }
//        return false;
//    }

    // 12ms N +

}
