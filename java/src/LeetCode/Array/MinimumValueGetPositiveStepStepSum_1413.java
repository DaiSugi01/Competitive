package LeetCode.Array;

public class MinimumValueGetPositiveStepStepSum_1413 {
    /*
        Input: nums = [-3,2,-3,4,2]
        Output: 5

        {
            0: -3,
            1: -1,
            2: -4,
            3: 3,
            4: 5,
        }
     */
    public int minStartValue(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            minVal = Math.min(minVal, sum);
        }

        return -minVal + 1;
    }
}
