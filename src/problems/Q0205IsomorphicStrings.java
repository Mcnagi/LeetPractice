package problems;

import java.util.HashMap;
import java.util.Map;

public class Q0205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] f = new int[128];
        int[] fInverse = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (f[s.charAt(i)] != 0) {
                if (f[s.charAt(i)] != t.charAt(i)
                        || fInverse[t.charAt(i)] != s.charAt(i)) return false;
            } else if (fInverse[t.charAt(i)] != 0) {
                return false;
            } else {
                f[s.charAt(i)] = t.charAt(i);
                fInverse[t.charAt(i)] = s.charAt(i);
            }
        }
        return true;
    }

//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        Map<Character, Character> map = new HashMap<>();
//        Map<Character, Character> mapInverse = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char a = s.charAt(i);
//            char b = t.charAt(i);
//            if (!map.containsKey(a)) {
//                if (mapInverse.containsKey(b)) return false;
//                map.put(a, b);
//                mapInverse.put(b, a);
//            } else if (map.get(a) != b || mapInverse.get(b) != a) return false;
//        }
//        return true;
//    }
}
