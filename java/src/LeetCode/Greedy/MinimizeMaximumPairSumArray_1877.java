package LeetCode.Greedy;

import java.util.Arrays;

public class MinimizeMaximumPairSumArray_1877 {
    /*
        [3,5,4,2,4,6]
        [2,3,4,4,5,6]
     */
    public int minPairSum(int[] nums) {
        if (nums.length == 2) return nums[0] + nums[1];

        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[len - i - 1]);
        }

        return ans;
    }
}
