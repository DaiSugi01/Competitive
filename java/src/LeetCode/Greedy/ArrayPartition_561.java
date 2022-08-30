package LeetCode.Greedy;

import java.util.Arrays;

public class ArrayPartition_561 {
    /*
        Input: nums = [6,2,6,5,1,2]
        Output: 9

        Sort the nums -> [1,2,2,5,6,6]
        loop through nums (nums / 2 times)
        use two pointers i, j
        [1,2,2,5,6,6]

        Output: 9
        [6,2,6,5,1,2]

     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i <= nums.length / 2 + 1; i += 2) {
            res += nums[i];
        }

        return res;
    }
}
