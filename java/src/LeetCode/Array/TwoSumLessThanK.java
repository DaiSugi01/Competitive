//https://leetcode.com/problems/two-sum-less-than-k/
package LeetCode.Array;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int res = -1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                res = Math.max(res, sum);
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
