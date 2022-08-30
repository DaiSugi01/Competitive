package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            List<Integer> prev = res.get(i - 1);
            for (int j = 1; j <= prev.size() - 1; j++) {
                nums.add(prev.get(j - 1) + prev.get(j));
            }
            nums.add(1);
            res.add(nums);
        }

        return res;
    }
}
