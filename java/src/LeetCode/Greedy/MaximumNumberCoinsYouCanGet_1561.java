package LeetCode.Greedy;

import java.util.Arrays;

public class MaximumNumberCoinsYouCanGet_1561 {
    /*
        [1,2,2,4,7,8]
        8,7,1
        4,2,2

        [1,2,3,4,5,6,7,8,9]
        9,8,1
        7,6,2
        5,4,3
     */

    public int maxCoins(int[] piles) {
        int maxCoin = 0;
        Arrays.sort(piles);
        for (int i = piles.length - 2; i >= piles.length / 3; i -= 2) {
            maxCoin += piles[i];
        }

        return maxCoin;
    }
}
