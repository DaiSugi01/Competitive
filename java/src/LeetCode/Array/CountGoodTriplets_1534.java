//https://leetcode.com/problems/count-good-triplets/description/
package LeetCode.Array;

public class CountGoodTriplets_1534 {
    /*
        Conditions;
        - 0 <= i < j < k < arr.length
        - |arr[i] - arr[j]| <= a
        - |arr[j] - arr[k]| <= b
        - |arr[i] - arr[k]| <= c

        Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
        Output: 4
        Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
