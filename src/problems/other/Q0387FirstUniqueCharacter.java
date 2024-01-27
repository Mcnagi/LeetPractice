package problems.other;

import java.util.*;

public class Q0387FirstUniqueCharacter {
  // s consists of only lowercase English letters.
  public int firstUniqChar(String s) {
    Map<Character, Integer> good = new HashMap<>();
    Set<Character> noGood = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (noGood.contains(c)) continue;
      if (good.containsKey(c)) {
        good.remove(c);
        noGood.add(c);
      } else {
        good.put(c, i);
      }
    }
    return good.values().stream().min(Integer::compare).orElse(-1);
  }
  // 31ms
  //    public int firstUniqChar(String s) {
  //        Map<Character, Integer> map = new HashMap<>();
  //        Set<Character> set = new HashSet<>();
  //        for (int i = 0; i < s.length(); i++) {
  //            if (set.contains(s.charAt(i))) map.remove(s.charAt(i));
  //            else {
  //                set.add(s.charAt(i));
  //                map.put(s.charAt(i), i);
  //            }
  //        }
  //        return map.values().stream().min(Integer::compare).orElse(-1);
  //    }
}
