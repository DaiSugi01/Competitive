package LeetCode.DP;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /*
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.

        [-2,1,-3,4,-1,2,1,-5,4]
        sum = nums[0]
        loop through nums array from 1 index.
            sum += i
            compare sum to i   -> sum = Math.max(sum, i)
            ans =   Math.max(ans, sum)
     */
    public static int maxSubArray(int[] nums) {
        int maxSubArrSum = nums[0];
        int subArrSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subArrSum += nums[i];
            subArrSum = Math.max(subArrSum, nums[i]);
            maxSubArrSum = Math.max(maxSubArrSum, subArrSum);
        }
        return maxSubArrSum;
    }
}
