package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q0242Test {
    public void testTrue(String s, String t) {
        var q = new Q0242ValidAnagram();
        var actual = q.isAnagram(s,t);
        Assertions.assertTrue(actual,
                String.format("Expect to be true but got %s with input: %s", actual, s + ", " + t));
    }
    public void testFalse(String s, String t) {
        var q = new Q0242ValidAnagram();
        var actual = q.isAnagram(s,t);
        Assertions.assertFalse(actual,
                String.format("Expect to be false but got %s with input: %s", actual, s + ", " + t));
    }
    @Test
    public void testSimple() {
        testTrue("aabc", "acba");
        testTrue("aaaa", "aaaa");
        testTrue("aaaab", "baaaa");

        testFalse("aa", "bb");
        testFalse("aa", "ab");
    }
    @Test
    public void testHard() {
        testFalse("abcdefghijklmn", "abcdefghijklmno");
        List<String> testCase = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader("./test/Q0242TrueTestCase.txt"))) {
            while (true) {
                var line = reader.readLine();
                if (line == null) break;
                testCase.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < testCase.size() / 2; i++) {
            testTrue(testCase.get(i * 2), testCase.get(i * 2 + 1));
        }
    }

}
