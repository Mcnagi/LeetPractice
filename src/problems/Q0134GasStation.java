package problems;

public class Q0134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int[] cumulative = new int[gas.length + 1];
        for (int i = 0; i < gas.length; i++) {
            cumulative[i + 1] = cumulative[i] + gas[i] - cost[i];
            if (cumulative[i] - cumulative[result] < 0) result = i;
        }
        if (cumulative[cumulative.length - 1] < 0) return -1;
        return result;
    }
}
