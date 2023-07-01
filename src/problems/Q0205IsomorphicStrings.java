package problems;

import java.util.HashMap;
import java.util.Map;

public class Q0205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> mapInverse = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map.containsKey(a)) {
                if (mapInverse.containsKey(b)) return false;
                map.put(a, b);
                mapInverse.put(b, a);
            } else if (map.get(a) != b || mapInverse.get(b) != a) return false;
        }
        return true;
    }
}
