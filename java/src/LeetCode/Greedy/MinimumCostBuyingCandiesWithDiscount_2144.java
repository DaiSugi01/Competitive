package LeetCode.Greedy;

import java.util.Arrays;

public class MinimumCostBuyingCandiesWithDiscount_2144 {
    public int minimumCost(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];

        Arrays.sort(cost);
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (i % 3 != cost.length % 3)
                sum += cost[i];
        }

        return sum;
    }
}
