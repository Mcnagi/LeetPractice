package problems;

public class Q0010RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return matchHelper(s, p , 0, 0);
    }

    public boolean matchHelper(String s, String p, int indexS, int indexP) {
        if (indexS == s.length()) {
            if (indexP < p.length()
                    && (p.charAt(indexP) != '*'
                    || (p.charAt(indexP) == '*' && indexP + 1 < p.length()))) return false;
            else return true;
        } else if (indexP == p.length()) return false;

        char pattern = p.charAt(indexP);
        char c = s.charAt(indexS);
        if (pattern == '.' || pattern == c) {
            return matchHelper(s, p ,indexS + 1, indexP + 1);
        } else if (pattern == '*') {
            char prevPattern = p.charAt(indexP - 1);
            if (prevPattern == '.' || prevPattern == c) return matchHelper(s, p, indexS + 1, indexP);
            else return matchHelper(s, p, indexS, indexP + 1);
        }
        return false;
    }
}
