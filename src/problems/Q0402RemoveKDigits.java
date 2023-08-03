package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q0402RemoveKDigits {

    Integer[] indices;
    int size = 0;
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        indices = new Integer[num.length() - k];

        for (int i = 0; i < num.length(); i++) {

        }

        StringBuilder builder = new StringBuilder();
        for (Integer index : indices) {
            if (index == null) break;
            builder.append(index);
        }
        return builder.isEmpty() ? "0" : builder.toString();
    }
    void add(int value) {
        indices[size ++] = value;
    }
    int getLastIndex() {
        return indices[size - 1];
    }
    void replaceAt(int value, int index) {
        indices[index] = value;
    }
    void replaceLast(int value) {
        indices[size - 1] = value;
    }
}
