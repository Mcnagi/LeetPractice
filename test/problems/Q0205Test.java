package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Q0205Test {
    public void testTrue(String input, String input2) {
        var q = new Q0205IsomorphicStrings();
        var actual = q.isIsomorphic(input, input2);
        Assertions.assertTrue(actual,
                String.format("Expect to be true but got %s with input: %s",
                        actual, input + ", " + input2));
    }
    public void testFalse(String input, String input2) {
        var q = new Q0205IsomorphicStrings();
        var actual = q.isIsomorphic(input, input2);
        Assertions.assertFalse(actual,
                String.format("Expect to be false but got %s with input: %s",
                        actual, input + ", " + input2));
    }

    @Test
    public void testOne() {
        Random rand = new Random();
        for (int i = 0; i < 26; i++) {
            testTrue(String.valueOf((char)('a' + i)), "a");
            testTrue(String.valueOf((char)('a' + i)),
                    String.valueOf((char)('a' + (i + rand.nextInt()) % 26 )));

            testFalse(String.valueOf((char)('a' + i)), "ab");
        }
    }

    @Test
    public void testTwo() {
        testTrue("ab", "ab");
        testTrue("ab", "cd");
        testTrue("ab", "xy");
        testTrue("xy", "ab");
        testTrue("xy", "xa");

        testFalse("xy", "xx");
        testFalse("xy", "xyz");
        testFalse("xyz", "xyy");
        testFalse("xyz", "xy");
        testFalse("xx", "xy");
    }

    @Test
    public void testHasSame() {
        testTrue("aa", "aa");
        testTrue("aa", "bb");
        testTrue("aa", "xx");

        testTrue("aba", "xbx");
        testTrue("aba", "zcz");
        testTrue("aab", "xxa");
        testTrue("aab", "zzb");
        testTrue("aab", "yyc");
        testTrue("egg", "add");

        testFalse("aa", "ab");
        testFalse("aa", "aab");

        testFalse("aab", "acb");
        testFalse("aab", "aa");
        testFalse("aab", "bbb");
        testFalse("aab", "aaa");

        testFalse("aab", "aba");
        testFalse("aab", "xkx");
        testFalse("foo", "bar");
    }

    @Test
    public void testLong() {
        testTrue("paper", "title");
        testTrue("sheep", "spoon");
        testTrue("dish", "card");
        testTrue("dish", "rand");
        testTrue("apple", "addre");
        testTrue("australia", "bcvnrbmib");


        testFalse("apple", "eddre");
        testFalse("paper", "ppaer");
    }
}
