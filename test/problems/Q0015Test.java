// package problems;
//
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
//
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
//
// public class Q0015Test {
//    public boolean testList(Set<List<Integer>> expected, List<List<Integer>> result) {
//        if (expected.size() != result.size()) return false;
//
//        return true;
//    }
//    public void test(Set<List<Integer>> expected, int[] input) {
//        var q = new Q0015ThreeSum();
//        var output = q.threeSum(input);
//        Set<List<Integer>> outputSet = new HashSet<>();
//        for (var list : output) {
//            outputSet.add(new ArrayList<>(list));
//        }
//        Assertions.assertEquals(expected, outputSet,
//                String.format("Expect to have %s with input: %s", expected, outputSet));
//    }
//
//    @Test
//    public void testEmptyResult() {
//        test(new HashSet<>(), new int[]{0, 1, 1});
//        test(new HashSet<>(), new int[]{0, -2, 1});
//        test(new HashSet<>(), new int[]{0, -2, -2});
//        test(new HashSet<>(), new int[]{1, 1, 1});
//        test(new HashSet<>(), new int[]{1, 1, 1, 1});
//        test(new HashSet<>(), new int[]{1, 1, -1, -1});
//    }
//    @Test
//    public void testOne() {
//        Set<List<Integer>> tmp = new HashSet<>();
//        tmp.add(new ArrayList<>(List.of(0,0,0)));
//        test(tmp, new int[]{0, 0, 0});
//
//        tmp = new HashSet<>();
//        tmp.add(new ArrayList<>(List.of(0, -1, 1)));
//        test(tmp, new int[]{0, -1, 1});
//    }
//
//    @Test
//    public void testMedian() {
//
//    }
//
//    @Test
//    public void testHard() {
//
//    }
// }
