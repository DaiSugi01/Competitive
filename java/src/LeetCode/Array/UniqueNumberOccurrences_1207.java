package LeetCode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        Set<Integer> set = new HashSet<>();
        for (int i : freq.values()) {
            if (set.contains(i)) return false;
            set.add(i);
        }
        return true;
    }
}
