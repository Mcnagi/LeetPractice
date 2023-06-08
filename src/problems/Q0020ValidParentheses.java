package problems;

public class Q0020ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;
        Character[] array = new Character[n / 2];

        array[0] = s.charAt(0);
        int[] size = {1};

        for (int i = 1; i < n; i++) {
            char tmp = s.charAt(i);
            switch (tmp) {
                case ')' -> {
                    if (array[size[0] - 1] == '(') {
                        remove(array, size);
                        continue;
                    }
                }
                case ']' -> {
                    if (array[size[0] - 1] == '[') {
                    remove(array, size);
                    continue;
                    }}
                case '}' -> { if (array[size[0] - 1] == '{') {
                    remove(array, size);
                    continue;
                }}
            }
            array[size[0]] = tmp;
            size[0] += 1;
            if (size[0] == array.length) return false;
        }
        return size[0] ==0;
    }
    private void remove(Character[] array, int[] index) {
        array[index[0] - 1] = null;
        index[0] -= 1;
    }

}
