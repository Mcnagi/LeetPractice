package problems.Q0031_Q0060;

public class Q0058LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i --;
        }
        int e = i;
        while (i >=0 && s.charAt(i) != ' '){
            i --;
        }
        return e - i;
    }
}
