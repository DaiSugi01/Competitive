package LeetCode.Array;

public class CreateTargetArrayInTheGivenOrder_1389 {
    public static void main(String[] args) {
        createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
    }

    /*
        Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
        Output: [0,4,1,3,2]
        mapping {
            0: [0],
            1: [1,4]
            2: [2,3]
        }
     */
    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // shift elements
            for (int j = n - 1; j > index[i]; j--) {
                ans[j] = ans[j - 1];
            }
            ans[index[i]] = nums[i];
        }

        return ans;
    }
}
