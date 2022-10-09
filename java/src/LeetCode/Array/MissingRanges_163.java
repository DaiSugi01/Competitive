package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges_163 {
    /*
        Input: nums = [0,1,3,50,75], lower = 0, upper = 99
        Output: ["2","4->49","51->74","76->99"]
        Explanation: The ranges are:
        [2,2] --> "2"
        [4,49] --> "4->49"
        [51,74] --> "51->74"
        [76,99] --> "76->99"
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            if (upper == lower) {
                return new ArrayList<>(Arrays.asList(String.valueOf(lower)));
            } else {
                return new ArrayList<>(Arrays.asList((lower + 1) + "->" + (upper - 1)));
            }
        }
        List<String> res = new ArrayList<>();
        int cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - cur == 2) {
                res.add(String.valueOf(nums[i] - 1));
            } else if (nums[i] - cur > 1) {
                res.add(cur + 1 + "->" + (nums[i] - 1));
            }

            cur = nums[i];
        }

        if (upper - nums[nums.length - 1] == 2) {
            res.add(String.valueOf(nums[nums.length - 1]));
        } else if (upper - nums[nums.length - 1] > 1) {
            res.add(nums[nums.length - 1] + 1 + "->" + upper);
        }

        return res;
    }
}
