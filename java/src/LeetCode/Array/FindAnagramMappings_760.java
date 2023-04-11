//https://leetcode.com/problems/find-anagram-mappings/description/
package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings_760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length) return new int[]{};

        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        int[] mapping = new int[nums1.length];
        for (int i = 0; i < n; i++) {
            mapping[i] = map.get(nums1[i]);
        }

        return mapping;
    }
}
