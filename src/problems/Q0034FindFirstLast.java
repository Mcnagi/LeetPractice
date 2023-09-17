package problems;

public class Q0034FindFirstLast {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int s = 0, e = nums.length - 1;
        int k = (s + e ) / 2;
        while (s < e) {
            if (nums[k] == target) break;
            if (nums[k] < target) s = k + 1;
            else e = k - 1;
            k = (s + e ) / 2;
        }
        if (nums[k] != target) return new int[]{-1, -1};
        int left = k, right = k;
        s = 0;
        e = left;
        k = (s + e) / 2;
        while (s < e) {
            if (k == 0) {
                if (nums[0] == target) left = 0;
                else left = 1;
                break;
            }
            if (nums[k] == target && nums[k - 1] < target) {
                left = k;
                break;
            }
            if (nums[k] < target) s = k + 1;
            else e = k - 1;
            k = (s + e) / 2;
        }
        s = right;
        e = nums.length;
        k = (s + e) / 2;
        while (s < e) {
            if (k == nums.length - 1) {
             if (nums[k] == target) right = k;
             else right = k - 1;
            }
            if (nums[k] == target && nums[k + 1] > target) {
                right = k;
                break;
            }
            if (nums[k] < target) s = k + 1;
            else e = k - 1;
        }
        return new int[]{left, right};
    }

}
