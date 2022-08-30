package LeetCode.DP;

public class GetMaximumGeneratedArray_1646 {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }

    /*
        i=2
        [0,1,1,2,1,3,0,0,0,0,0,0,0,0,0,0]
     */
    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        int maximumValue = 1;
        nums[1] = 1;
 
        for (int i = 1; i <= n / 2; i++) {
            nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
                maximumValue = Math.max(maximumValue, nums[i * 2 + 1]);
            }
        }
        return maximumValue;
    }
}
