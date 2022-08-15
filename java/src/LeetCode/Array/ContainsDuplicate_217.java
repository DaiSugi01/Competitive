package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public static void main(String[] args) {
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
