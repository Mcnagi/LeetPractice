package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0030SubstringConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordSize = words[0].length();
        int numOfWords = words.length;

        if (wordSize * numOfWords > s.length()) return List.of();

        Map<String, Integer> map = new HashMap<>(words.length);
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        char[] chars = s.toCharArray();
        Map<String, Integer> count = new HashMap<>(words.length);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= chars.length - wordSize * numOfWords; i++) {
            int j = i;
            while (j <= chars.length - wordSize) {
                String w = new String(chars, j, wordSize);
                count.put(w, count.getOrDefault(w, 0) + 1);
                if (!map.containsKey(w) || count.get(w) > map.get(w)) break;
                j += wordSize;
            }
            if (j == i + wordSize * numOfWords) result.add(i);
            count.clear();
        }
        return result;
    }
}
