//https://leetcode.com/problems/left-and-right-sum-differences/
package LeetCode.Array;

public class LeftAndRightSumDifferences_2574 {
    public int[] leftRigthDifference(int[] nums) {
        if (nums.length == 0) return new int[]{};

        int n = nums.length;
        int ans[] = new int[n];
        int lSum = 0;
        int rSum = 0;

        for (int i = 0; i < n; i++)
            rSum += nums[i];

        for (int i = 0; i < n; i++) {
            rSum -= nums[i];
            ans[i] = Math.abs(rSum - lSum);
            lSum += nums[i];
        }

        return ans;
    }
}
