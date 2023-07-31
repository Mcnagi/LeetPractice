package problems;

public class Q0860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2];
        for (int value : bills) {
            if (value == 5) {
                changes[0] += 1;
                continue;
            }
            else if (value == 10) {
                changes[0] -= 1;
                changes[1] += 1;
            } else {
                if (changes[1] > 0) {
                    changes[1] -= 1;
                    changes[0] -= 1;
                } else changes[0] -= 3;
            }
            if (changes[0] < 0 || changes[1] < 0) return false;
        }
        return true;
    }
}
