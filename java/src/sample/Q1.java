package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1 {
    public ArrayList<ArrayList<Integer>> targetSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                pairs.add(new ArrayList<>(Arrays.asList(left++, right--)));
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
}
