/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q22 {
    public static void main(String[] args) {
        Q22 sol = new Q22();
        sol.permute(new int[]{1, 2, 3});
    }

    private static List<Integer> concatArr(List<Integer> first, List<Integer> rest, int i) {
        List<Integer> dist = new ArrayList<>();
        dist.addAll(rest.subList(0, i));
        dist.addAll(first.subList(0, 1));
        dist.addAll(rest.subList(i, rest.size()));
        return dist;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (elements.size() <= 1)
            return new ArrayList<>(new ArrayList<>(Arrays.asList(elements)));

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> perm : permute(Arrays.copyOfRange(nums, 1, nums.length))) {
            for (int i = 0; i < elements.size(); i++) {
                res.add(concatArr(elements.subList(0, 1), perm, i));
            }
        }

        return res;
    }
}
