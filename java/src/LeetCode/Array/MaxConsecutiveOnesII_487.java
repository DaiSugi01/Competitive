package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnesII_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nums[i] == 0) zeros.add(i);

        if (zeros.size() <= 1) return n;

        int res = zeros.get(1);
        int zerosCount = zeros.size();
        for (int i = 1; i < zeros.size(); i++) {
            int current = i == zerosCount - 1 ? n - 1 - zeros.get(i - 1) : zeros.get(i + 1) - zeros.get(i - 1) - 1;
            res = Math.max(res, current);
        }

        return res;
    }
}
