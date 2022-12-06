package LeetCode.Array;

public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1])
                start = i;
            longest = Math.max(longest, i - start + 1);
        }

        return longest;
    }
}
