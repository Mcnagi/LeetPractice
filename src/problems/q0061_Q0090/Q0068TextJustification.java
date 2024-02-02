package problems.q0061_Q0090;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Q0068TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        int i = 0;
        LinkedList<String> q = new LinkedList<>();
        int currentLength = 0;
        while (i < words.length) {
            if (q.isEmpty()) {
                q.add(words[i]);
                currentLength = words[i].length();
                i += 1;
            }
            else if (currentLength + words[i].length() < maxWidth) {
                q.add(words[i]);
                currentLength += (1 + words[i].length());
                i += 1;
            }
            else {
                result.add(distributeSpace(q, maxWidth, currentLength));
                currentLength = 0;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            builder.append(q.removeFirst());
            if (builder.length() < maxWidth) builder.append(" ");
        }
        if (!builder.isEmpty()) {
            while (builder.length() < maxWidth) builder.append(" ");
            result.add(builder.toString());
        }
        return result;
    }

    private String distributeSpace(LinkedList<String> words, int maxLength, int currentLength) {
        if (words.size() == 1) {
            StringBuilder builder = new StringBuilder(words.removeFirst());
            builder.append(" ".repeat(maxLength - builder.length()));
            return builder.toString();
        }
        StringBuilder builder = new StringBuilder();

        int gaps = words.size() - 1;
        int wordLength = currentLength - words.size() + 1;
        int spaceLength = maxLength - wordLength;
        int avgSpace = spaceLength / gaps;
        int r = spaceLength % gaps;
        while (words.size() > 1) {
            builder.append(words.removeFirst());
            builder.append(" ".repeat(avgSpace));
            if (r > 0) {
                builder.append(" ");
                r -= 1;
            }
        }
        builder.append(words.removeFirst());
        return builder.toString();
    }


}
