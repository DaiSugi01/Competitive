package LeetCode.Array;

public class CheckIfNumberMajorityElementSortedArray_1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) count++;
        }

        return count > nums.length / 2;
    }
}
