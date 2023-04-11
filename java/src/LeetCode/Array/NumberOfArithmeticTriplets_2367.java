//https://leetcode.com/problems/number-of-arithmetic-triplets/
package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets_2367 {
    public static void main(String[] args) {
        arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
    }

    /*
        Input: nums = [0,1,4,6,7,10], diff = 3
        Output: 2
     */
    public static int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(n - diff * 2) && seen.contains(n - diff)) {
                res++;
            }
            seen.add(n);
        }
        return res;
    }
}
