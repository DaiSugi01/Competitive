package LeetCode.Array;

public class ShuffletheArray_1470 {
    public int[] shuffle(int[] nums, int n) {
        int middle = nums.length / 2;
        int[] ans = new int[2 * n];
        int p = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans[p++] = nums[i];
            ans[p++] = nums[middle++];
        }
        return ans;
    }
}
