package problems.other;

public class Q0242ValidAnagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] sCount = new int[26];
    int[] tCount = new int[26];
    for (int i = 0; i < s.length(); i++) {
      sCount[s.charAt(i) - 'a'] += 1;
      tCount[t.charAt(i) - 'a'] += 1;
    }
    for (int i = 0; i < sCount.length; i++) {
      if (sCount[i] != tCount[i]) return false;
    }

    return true;
  }

  // 30ms
  //    public boolean isAnagram(String s, String t) {
  //        if (s.length() != t.length()) return false;
  //
  //        Map<Character, Integer> sCount = new HashMap<>();
  //        Map<Character, Integer> tCount = new HashMap<>();
  //
  //        for (int i = 0; i < s.length(); i++) {
  //            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
  //            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
  //        }
  //        for (var key : sCount.keySet()) {
  //            if (!tCount.containsKey(key) || !Objects.equals(sCount.get(key), tCount.get(key)))
  // return false;
  //        }
  //        return true;
  //    }
}
