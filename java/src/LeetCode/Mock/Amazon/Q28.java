package LeetCode.Mock.Amazon;

import java.util.Arrays;

public class Q28 {
    /*
        n=7
        k=1 7
        k=2 6
        k=3 3
        k=4 2
        k=5 X
        k=6 X
        k=7 1
        Input: stones = [3,5,1,2,6,7,8], k = 3
        Output: 25
     */
    public int mergeStones(int[] stones, int k) {
        if ((stones.length - 1) % (k - 1) != 0) return -1;

        for (int i = 0; i < stones.length; i++) {

        }

        return 1;
    }

    private int helper(int[] stones, int k) {
        if (stones.length < k) return -1;
        if (stones.length == k) return Arrays.stream(stones).sum();
        int size = stones.length;
        while (size >= k) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < stones.length; i++) {
                if (min > stones[i]) {
                    idx = i;
                    min = stones[i];
                }
            }

            int l = idx - 1;
            int r = idx + -1;
            while (l > 0 && r < size && r - l < k) {
                if (stones[l] > stones[r])
                    r++;
                else
                    l--;
            }
        }
        return 1;
    }
}
