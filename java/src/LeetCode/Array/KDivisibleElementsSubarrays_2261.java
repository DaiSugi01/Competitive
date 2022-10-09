package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class KDivisibleElementsSubarrays_2261 {
    public static void main(String[] args) {
        KDivisibleElementsSubarrays_2261 sol = new KDivisibleElementsSubarrays_2261();
        System.out.println(sol.countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println(sol.countDistinct(new int[]{1, 2, 3, 4}, 4, 1));
        System.out.println(sol.countDistinct(new int[]{10, 2, 17, 7, 20}, 1, 10));
    }

    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0)
                    count++;

                if (count > k)
                    break;

                sb.append(nums[j] + " ");

                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
