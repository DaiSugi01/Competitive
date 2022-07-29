//https://leetcode.com/problems/two-sum/
package LeetCode.Array;

import java.util.HashMap;

public class TwoSum_1 {
    /*
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]

        map {
            2: 0,
        }

        1. HashMap map
        2. loop through the nums array
            int diff = target - the current value
            if "map" has (target - the current value)
                return  new int[map.get(diff), current index]
            store the item into map. key->current val, val->index of the item
     */
    public int[] twoSum(int[] nums, int target) {
        int[] twoNums = new int[2];
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                twoNums = new int[]{numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }

        return twoNums;
    }
}
