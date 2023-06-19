package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0010Test {
    public void testTrue(String s, String pattern) {
        var q10 = new Q0010RegularExpressionMatching();
        Assertions.assertTrue(q10.isMatch(s, pattern),
                String.format("with input %s and pattern %s", s, pattern));
    }
    public void testFalse(String s, String pattern) {
        var q10 = new Q0010RegularExpressionMatching();
        Assertions.assertFalse(q10.isMatch(s, pattern),
                String.format("with input %s and pattern %s", s, pattern));
    }

    @Test
    public void testOne() {
        String[] ss = new String[]{"a", "b", "c", "d", "e"};
        String[] patterns = new String[] {"a", "b", "c", "d","e"};
        for (int i = 0; i < ss.length; i++)
            testTrue(ss[i], patterns[i]);
        for (int i = 0; i < 26; i++)
            testTrue(String.valueOf((char)('a' + i)), ".");
        for (int i = 0; i < 26; i++)
            testFalse(String.valueOf((char)('a' + i)), String.valueOf('a' + (i  + 1 ) % 26));
    }

    @Test
    public void testShort() {
        String[] ss = new String[]{"aa", "bbb", "cccc", "ddddd", "eddd"};
        String[] patterns = new String[] {"aa", "bbb", "cccc", "ddddd","eddd"};
        String[] patterns2 = new String[] {"a*", "bbb*", "c*", "d*","ed*"};
        String[] patternsFalse = new String[] {"aaaa", "bb", "c", "d","e"};
        for (int i = 0; i < ss.length; i++) {
            testTrue(ss[i], patterns[i]);
            testTrue(ss[i], patterns[i] + "*");
            testTrue(ss[i], patterns2[i]);
            testFalse(ss[i], patternsFalse[i]);
            testFalse(ss[i], "z");
        }
        testTrue("aab", "c*a*b");
        testTrue("ccc", "cc*");

        testFalse("ab", ".*c");
        testTrue("abc", ".*c");
        testTrue("abcabc", ".*c");
        testFalse("abcab", ".*c");

    }
    @Test
    public void testLong() {
        String[] ss = new String[]{"abcads", "bbbbbbb", "ccsaad", "abcdefg", "aabbccd","aabbccdeeee"};
        String[] patternsTrue1 = new String[]{"abcads", "bbbbbbb", "ccsaad", "abcdefg", "aabbccd","aabbccdeeee"};
        String[] patternsTrue2 = new String[] {"abcads", "b*", "c*sa*d", "abcdefg","a*b*c*d", "a*b*c*de*"};
        String[] patternsTrue3 = new String[] {"abcads*", "b*", "c*s*a*d*", "a*b*c*d*e*f*g*","a*b*c*d*", "a*b*c*d*e*"};
        String[] patternsFalse1 = new String[] {"abcad", "bbbb", "ccsaa", "abcdef","a*b*c*", "a*b*c*de"};
        String[] patternsFalse2 = new String[] {"a*", "b", "c*", "a*","a*b*", "a*b*"};
        for (int i = 0; i < ss.length; i++) {
            testTrue(ss[i], patternsTrue1[i]);
            testTrue(ss[i], patternsTrue2[i]);
            testTrue(ss[i], patternsTrue3[i]);
            testFalse(ss[i], patternsFalse1[i]);
            testFalse(ss[i], patternsFalse2[i]);
        }
    }
}
