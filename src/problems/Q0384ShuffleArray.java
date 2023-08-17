package problems;

import java.util.Random;

public class Q0384ShuffleArray {
    class Solution {
        int[] array;
        int[] shuffled;
        public Solution(int[] nums) {
            this.array = nums;
            this.shuffled = nums.clone();
        }

        public int[] reset() {
            return array;
        }

        public int[] shuffle() {
            var rand = new Random();
            for (int i = 0; i < shuffled.length / 2; i++) {
                int a = rand.nextInt(shuffled.length);
                int b = rand.nextInt(shuffled.length);
                int tmp = shuffled[a];
                shuffled[a] = shuffled[b];
                shuffled[b] = tmp;
            }
            return shuffled;
        }
    }

}
