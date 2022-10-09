package LeetCode.Array;

import java.util.Arrays;

public class SumClosest_16 {
    public static void main(String[] args) {
        SumClosest_16 sol = new SumClosest_16();
        sol.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    low++;
                else
                    high--;
                if (diff == 0)
                    return target;
            }
        }
        return target - diff;
    }
}
