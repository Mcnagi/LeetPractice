package problems;

public class Q0739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        result[result.length - 1] = 0;
        if (result.length == 1) return result;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) result[i] = 1;
            else {
                int j = i + result[i + 1];
                while (j < result.length) {
                    if (temperatures[i] < temperatures[j]) {
                        result[i] = j - i;
                        break;
                    } else if (result[j] == 0) break;
                    j += result[j];
                }
            }
        }
        return result;
    }


}
