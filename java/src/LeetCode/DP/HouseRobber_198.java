package LeetCode.DP;

public class HouseRobber_198 {
    public static void main(String[] args) {
        HouseRobber_198 sol = new HouseRobber_198();
        System.out.println(sol.rob(new int[]{1, 2, 3, 1}));
    }

    /*
        Input: nums = [3,1,3,1,4,6,1]
        output:12  3,3,6

        [0,3,1,6,4,10,12,11]
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
