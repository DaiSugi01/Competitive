package LeetCode.Array;

import java.util.*;

public class SortArrayByIncreasingFrequency_1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (i1, i2) -> map.get(i1) == map.get(i2) ? i2 - i1 : map.get(i1) - map.get(i2));

        int[] res = new int[nums.length];
        int i = 0;
        for (int n : list) {
            for (int j = 0; j < map.get(n); j++)
                res[i++] = n;
        }

        return res;
    }
}
