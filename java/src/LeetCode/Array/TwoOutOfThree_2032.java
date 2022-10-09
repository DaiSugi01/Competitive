package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree_2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for (int num : nums1)
            set.add(num);

        for (int num : nums2) {
            if (set.contains(num))
                common.add(num);
            else
                set2.add(num);
        }

        for (int num : nums3) {
            if (set.contains(num) | set2.contains(num))
                common.add(num);
        }

        return new ArrayList<>(common);
    }
}
