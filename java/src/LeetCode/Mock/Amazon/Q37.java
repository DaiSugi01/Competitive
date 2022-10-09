package LeetCode.Mock.Amazon;

public class Q37 {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] < k)
                    ans = Math.max(ans, nums[i] + nums[j]);
            }
        }
        return ans;
    }
}
