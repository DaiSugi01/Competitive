package LeetCode.Array;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing_1909 {
    public static void main(String[] args) {
        RemoveOneElementToMakeTheArrayStrictlyIncreasing_1909 sol = new RemoveOneElementToMakeTheArrayStrictlyIncreasing_1909();
        System.out.println(sol.canBeIncreasing(new int[]{49, 318, 129, 218, 306, 73, 756, 897, 992}) == false);
        System.out.println(sol.canBeIncreasing(new int[]{100, 21, 100}) == true);
        System.out.println(sol.canBeIncreasing(new int[]{1, 2, 10, 5, 7}) == true);
        System.out.println(sol.canBeIncreasing(new int[]{2, 3, 1, 2}) == false);
        System.out.println(sol.canBeIncreasing(new int[]{1, 1, 1}) == false);
        System.out.println(sol.canBeIncreasing(new int[]{105, 924, 32, 968}) == true);
        System.out.println(sol.canBeIncreasing(new int[]{13, 205, 553, 527, 790, 238}) == false);
        System.out.println(sol.canBeIncreasing(new int[]{205, 553, 13, 12, 790, 238}) == false);
    }

    public boolean canBeIncreasing(int[] nums) {
        boolean foundBigger = nums[0] >= nums[1];
        int prev = foundBigger ? Math.min(nums[0], nums[1]) : nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > prev) {
                prev = nums[i];
                continue;
            }

            if (foundBigger) {
                if (nums[i] <= prev) return false;
            } else {
                if (nums[i] <= nums[i - 2])
                    prev = nums[i - 1];
                else
                    prev = Math.min(prev, nums[i]);
                foundBigger = true;
            }
        }

        return true;
    }
}
