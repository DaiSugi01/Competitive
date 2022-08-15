package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public static void main(String[] args) {
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > nums.length / 2) {
                return n;
            }
        }
        return -1;
    }
}
