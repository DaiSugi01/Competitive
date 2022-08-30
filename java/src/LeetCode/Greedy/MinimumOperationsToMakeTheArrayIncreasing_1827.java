package LeetCode.Greedy;

public class MinimumOperationsToMakeTheArrayIncreasing_1827 {
    public static void main(String[] args) {
    }

    /*
        Input: nums = [1,1,1]
        Output: 3
        Explanation: You can do the following operations:
        1) Increment nums[2], so nums becomes [1,1,2].
        2) Increment nums[1], so nums becomes [1,2,2].
        3) Increment nums[2], so nums becomes [1,2,3].

        loop through the array
            if nums[i] >= nums[i+1]
                increased nums[i+1] while it will be greater than nums[i]
                count how many times increase the num.
     */
    public int minOperations(int[] nums) {
        int numOfIncreased = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                numOfIncreased += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }

        return numOfIncreased;
    }
}
