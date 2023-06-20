package problems;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.List;

public class Q0010RegularExpressionMatching {

    char prevPChar = ' ';
    int offset = 1;
    int sLength;
    public boolean isMatch(String s, String p) {
        sLength = s.length();
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == sLength) {
            if (pIndex == p.length()) return true;
            else if (p.charAt(pIndex) == '*') {
                return isMatch(s, sIndex, p, pIndex + 1);
            } else if (pIndex + 1 < p.length()) {
                if (p.charAt(pIndex + 1) == '*') return isMatch(s, sIndex, p, pIndex + 2);
                return false;
            }
            return false;

        } else if (pIndex == p.length()) return false;

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        if (sChar == pChar || pChar == '.') {
            prevPChar = pChar;
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        } else if (pChar == '*'
                && (sChar == prevPChar || prevPChar == '.')) {
            for (; offset < sLength - sIndex; offset++) {
                if (isMatch(s, sIndex + offset, p, pIndex + 1)) return true;
            }
            return false;
        }
        return false;
    }

}
