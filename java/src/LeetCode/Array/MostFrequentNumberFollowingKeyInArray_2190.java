package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInArray_2190 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int mostFreq = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
                if (map.get(nums[i + 1]) > max) {
                    max = map.get(nums[i + 1]);
                    mostFreq = nums[i + 1];
                }
            }
        }
        return mostFreq;
    }
}
