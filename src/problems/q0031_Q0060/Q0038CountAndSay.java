package problems.q0031_Q0060;

public class Q0038CountAndSay {
  static String[] sayings = new String[31];

  static {
    sayings[0] = "1";
    sayings[1] = "1";
  }

  public String countAndSay(int n) {
    if (n == 1) return "1";
    if (sayings[n] != null) return sayings[n];
    if (sayings[n - 1] == null) sayings[n - 1] = countAndSay(n - 1);
    return countAndSayHelper(sayings[n - 1]);
  }

  private String countAndSayHelper(String s) {
    char prev = s.charAt(0);
    int count = 1;
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == prev) count += 1;
      else {
        builder.append(count).append(prev);
        prev = s.charAt(i);
        count = 1;
      }
    }
    builder.append(count).append(prev);
    return builder.toString();
  }
}
