package LeetCode.Array;

public class RunningSumof1dArray_1480 {
    public static void main(String[] args) {
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
//        int[] sumArr = new int[nums.length];
//        sumArr[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            sumArr[i] = sumArr[i - 1] + nums[i];
//        }
//
//        return sumArr;
    }
}
