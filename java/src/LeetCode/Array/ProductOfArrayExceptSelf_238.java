package LeetCode.Array;

public class ProductOfArrayExceptSelf_238 {
    /*
        [1,2,3,4]
        [1,1,2,12]
        [24,12,4,1]
     */
    public int[] productExceptSelf(int[] nums) {
        boolean zeroInclude = false;
        int sum = 1;
        for (int n : nums) {
            if (n != 0)
                sum *= n;
            else
                zeroInclude = true;
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroInclude) {
                if (nums[i] == 0)
                    ans[i] = sum;
                else
                    ans[i] = 0;
            } else {
                ans[i] = sum / nums[i];
            }
        }

        return ans;
    }
}
