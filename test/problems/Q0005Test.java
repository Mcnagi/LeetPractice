package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author user.name
 */
public class Q0005Test {
    public void test(String input, Set<String> output) {
        var tmp = new Q0005LongestPalindromicSubstring();
        var actual = tmp.longestPalindrome(input);
        Assertions.assertTrue(output.contains(actual),
                "Output: \"" + actual + "\" is not the longest, with Input: " + input );
    }
    @Test
    public void testSingle() {
        test("A", Set.of("A"));
        test("A1", Set.of("A", "1"));
        test("B", Set.of("B"));
        test("s", Set.of("s"));
        test("10", Set.of("1", "0"));
        test("10c", Set.of("1", "0", "c"));
        test("abcde", Set.of("a", "b", "c", "d", "e"));
    }

    @Test
    public void testShort() {
        test("babad", Set.of("bab", "aba"));
        test("cbbd", Set.of("bb"));
        test("1123", Set.of("11"));
        test("31123", Set.of("11"));
    }
    @Test
    public void testLong() {
        // TestLetters
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            builder.append((char)('a' + i));
        }
        for (int i = 0; i < 26; i++) {
            builder.append((char)('z' - i));
        }
        test(builder.toString(), Set.of(builder.toString()));

        // Test all a's
        builder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            builder.append('a');
        }
        test(builder.toString(), Set.of(builder.toString()));

        // Test numeric
        builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            builder.append(i % 9);
        }
        for (int i = 0; i < 15; i++) {
            builder.append((15 - 1- i) % 9);
        }
        test(builder.toString(), Set.of(builder.toString()));
    }

}
