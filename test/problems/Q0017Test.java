package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0017Test {
  public void test(Set<String> expected, String input) {
    var q = new Q0017LetterCombinations();
    var actual = q.letterCombinations(input);
    if (actual == null) actual = new ArrayList<>(List.of("!"));
    Assertions.assertTrue(
        expected.containsAll(actual) && expected.size() == actual.size(),
        String.format("Expect to have %s but have %s with input: %s", expected, actual, input));
  }

  @Test
  public void testEmpty() {
    test(new HashSet<>(), "");
  }

  @Test
  public void testOne() {
    test(new HashSet<>(Set.of("a", "b", "c")), "2");
    test(new HashSet<>(Set.of("d", "e", "f")), "3");
    test(new HashSet<>(Set.of("g", "h", "i")), "4");
    test(new HashSet<>(Set.of("j", "k", "l")), "5");
    test(new HashSet<>(Set.of("m", "n", "o")), "6");
    test(new HashSet<>(Set.of("p", "q", "r", "s")), "7");
    test(new HashSet<>(Set.of("w", "x", "y", "z")), "9");
  }

  @Test
  public void testTwo() {
    test(new HashSet<>(Set.of("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc")), "22");
    test(new HashSet<>(Set.of("gj", "gk", "gl", "hj", "hk", "hl", "ij", "ik", "il")), "45");
    test(
        new HashSet<>(
            Set.of("wa", "wb", "wc", "xa", "xb", "xc", "ya", "yb", "yc", "za", "zb", "zc")),
        "92");
    test(
        new HashSet<>(
            Set.of("aw", "ax", "ay", "az", "bw", "bx", "by", "bz", "cw", "cx", "cy", "cz")),
        "29");
  }

  @Test
  public void testThree() {
    test(
        new HashSet<>(
            Set.of(
                "aaa", "aab", "aac", "aba", "abb", "abc", "aca", "acb", "acc", "baa", "bab", "bac",
                "bba", "bbb", "bbc", "bca", "bcb", "bcc", "caa", "cab", "cac", "cba", "cbb", "cbc",
                "cca", "ccb", "ccc")),
        "222");
    test(
        new HashSet<>(
            Set.of(
                "adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi",
                "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei",
                "cfg", "cfh", "cfi")),
        "234");

    test(
        new HashSet<>(
            Set.of(
                "gda", "gdb", "gdc", "gea", "geb", "gec", "gfa", "gfb", "gfc", "hda", "hdb", "hdc",
                "hea", "heb", "hec", "hfa", "hfb", "hfc", "ida", "idb", "idc", "iea", "ieb", "iec",
                "ifa", "ifb", "ifc")),
        "432");
  }
}
