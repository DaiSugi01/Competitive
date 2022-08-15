package LeetCode.BinarySearch;

public class BinarySearch_704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /*
        I'll use 2 pointer called left (0) and right (length of array)
        take a middle place by (left + right) / 2
        check if the middle item is the target item or not while left < right
        if the middle item is greater than the target, move right pointer to middle,
        else if the middle item is less than the target, move left pointer to middle + 1
        [1,2,3,4,5]
     */
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
