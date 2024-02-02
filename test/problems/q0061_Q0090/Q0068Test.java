package problems.q0061_Q0090;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q0068Test {

    public void test(List<String> expected, String[] words, int maxWidth) {
        var q = new Q0068TextJustification();
        var actual = q.fullJustify(words, maxWidth);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with String: %s\n and maxWidth: %s",
                        expected, actual, Arrays.toString(words), maxWidth));
    }

    @Test
    public void testLeetcodeExample() {
        test(List.of(new String[] {"This    is    an","example  of text","justification.  "}),
                new String[] {"This", "is", "an", "example", "of", "text", "justification."},
                16);

        test(List.of(new String[] {"What   must   be","acknowledgment  ","shall be        "}),
            new String[] {"What","must","be","acknowledgment","shall","be"},
                16);

        test(List.of("Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "),
                new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
                20);

    }

}
