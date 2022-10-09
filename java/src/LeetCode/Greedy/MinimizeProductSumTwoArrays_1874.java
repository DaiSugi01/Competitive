package LeetCode.Greedy;

import java.util.Arrays;

public class MinimizeProductSumTwoArrays_1874 {
    /*
        Input: nums1 = [5,3,4,2], nums2 = [4,2,2,5]
        Output: 40

        sort both arrays
        i = 0
        j = nums1.length-1
        while loop through array
            sum += nums1[i++] * nums2[j--]
     */
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = nums1.length - 1;
        int minSum = 0;
        while (i < nums1.length) {
            minSum += nums1[i++] * nums2[j--];
        }
        return minSum;
    }
}
