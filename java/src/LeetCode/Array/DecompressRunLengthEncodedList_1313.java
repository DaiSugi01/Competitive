package LeetCode.Array;

public class DecompressRunLengthEncodedList_1313 {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }

        int[] ans = new int[len];
        int p = 0;
        for (int i = 1; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                ans[p++] = nums[i];
            }
        }

        return ans;
    }
}
