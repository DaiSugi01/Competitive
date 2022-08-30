package LeetCode.Greedy;

import java.util.Arrays;

public class MinimumSumFourDigitNumberAfterSplittingDigits_2160 {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        for (int i = 3; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(nums);
        return (nums[0] * 10 + nums[2]) + (nums[1] * 10 + nums[3]);
    }
}
