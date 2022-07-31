package LeetCode.Array;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    /*
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

        loop through arr and keep tracking last position of non-zero val (int lastNonZeroPosition)

        e.g.
            lastNonZeroPosition = 1; increment if it finds non-zero val
            cur = 3; every single time increment by 1.
            [1,3,0,0,12]
     */
    public static void moveZeroes(int[] nums) {
        int lastNonZeroPosition = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, cur, lastNonZeroPosition);
                lastNonZeroPosition++;
            }
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
