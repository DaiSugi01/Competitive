package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_1200 {
    /*
        Input: arr = [4,2,1,3]
        Output: [[1,2],[2,3],[3,4]]
     */
    public static void main(String[] args) {
        minimumAbsDifference(new int[]{4, 2, 1, 3});
    }

    /*
            sort the arr = [1,2,3,4] (n log n)
            find the min diff by looping through the arr ( arr[i+1] - arr[i] ) -> min = 1
            loop through again
                if arr[i+1] - arr[i] == diff
                    append item to answer arr
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }
}
