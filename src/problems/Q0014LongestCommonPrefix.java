package problems;

public class Q0014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        StringBuilder builder = new StringBuilder();
        int i = 0;
        boolean good = true;
        while (good && i < strs[0].length()) {
            good = false;
            Character c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    good = false;
                    break;
                }
                good = true;
            }
            if (!good) break;
            builder.append(c);
            i++;
        }
        return builder.toString();
    }
}
