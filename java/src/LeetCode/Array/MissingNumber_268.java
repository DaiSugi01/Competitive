package LeetCode.Array;

public class MissingNumber_268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9}));
    }

    /*
        Input: nums = [3,0,1]
        Output: 2
     */
    public static int missingNumber(int[] nums) {
        int expected = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expected - actualSum;
    }
}
