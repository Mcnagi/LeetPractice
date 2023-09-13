package problems;

import java.util.*;

public class Q0049GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, Integer> map = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    for (String s : strs) {
      int[] count = new int[26];
      for (Character c : s.toCharArray()) count[c - 'a'] += 1;
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < count.length; i++) {
        builder.append((char) ('a' + i));
        builder.append(count[i]);
      }
      String tmp = builder.toString();
      if (map.containsKey(tmp)) (result.get(map.get(tmp))).add(s);
      else {
        map.put(tmp, map.size());
        result.add(new ArrayList<>(List.of(s)));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    var q = new Q0049GroupAnagrams();
    System.out.println(q.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
}
