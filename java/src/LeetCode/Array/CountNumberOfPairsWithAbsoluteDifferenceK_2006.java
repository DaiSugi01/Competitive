//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK_2006 {
    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{7, 7, 8, 3, 1, 2, 7, 2, 9, 5}, 6));
    }

    /*
        Input: nums = [7,7,8,3,1,2,7,2,9,5], k = 6
        Output: 6

        2 + 1 + 1 + 1 + 1
     */
    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            if (seen.containsKey(n - k))
                res += seen.get(n - k);
            if (seen.containsKey(k + n))
                res += seen.get(k + n);
            seen.put(n, seen.getOrDefault(n, 0) + 1);
        }

        return res;
    }
}
