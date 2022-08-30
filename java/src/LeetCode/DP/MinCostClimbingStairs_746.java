package LeetCode.DP;

public class MinCostClimbingStairs_746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 3, 2, 5, 6, 4}));
    }

    /*
        minCosts: [0, 0, 1, 3, 3, 8, 9]
        cost:     [1, 3, 2, 5, 6, 4]
        output: 9
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length + 1];

        for (int i = 2; i < minCosts.length; i++) {
            int oneStep = minCosts[i - 1] + cost[i - 1];
            int twoStep = minCosts[i - 2] + cost[i - 2];
            minCosts[i] = Math.min(oneStep, twoStep);
        }

        return minCosts[minCosts.length - 1];
    }
}
