package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q0017LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combinationHelper(digits.charAt(i), result);
        }
        return result;
    }
    public List<String> combinationHelper(char c, List<String> current) {
        List<String> result = new ArrayList<>();
        for (String s : current) {
            result.addAll(
            switch(c) {
                case '2' -> Set.of(s+'a', s+'b', s+'c');
                case '3' -> Set.of(s+'d', s+'e', s+'f');
                case '4' -> Set.of(s+'g', s+'h', s+'i');
                case '5' -> Set.of(s+'j', s+'k', s+'l');
                case '6' -> Set.of(s+'m', s+'n', s+'o');
                case '7' -> Set.of(s+'p', s+'q', s+'r', s+'s');
                case '8' -> Set.of(s+'t', s+'u', s+'v');
                case '9' -> Set.of(s+'w', s+'x', s+'y', s+'z');
                default -> throw new IllegalStateException("Unexpected value: " + c);
            });
        }
        return result;
    }

}
