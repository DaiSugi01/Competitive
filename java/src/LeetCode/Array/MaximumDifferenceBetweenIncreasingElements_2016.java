package LeetCode.Array;

public class MaximumDifferenceBetweenIncreasingElements_2016 {
    /*
        [7, 1, 5, 4]
        loop through the given array
            minimum value= Min(min, current value)
            if minimum value is smaller than current value (i)
                maximum value is equal Max(max, current - min) 4
            return max
    */
    public static int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            if (min < nums[i]) {
                max = Math.max(max, nums[i] - min);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7, 1, 5, 4}));
    }
}
