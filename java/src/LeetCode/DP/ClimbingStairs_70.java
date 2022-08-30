package LeetCode.DP;

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /*
        n=1
        [1]
        n=2
        [1,2]
        n=3 1,1,1 -- 1,2 -- 2,1
        [1,2,3]
        n=4 1,1,1,1 -- 1,1,2 -- 1,2,1 -- 2,1,1 -- 2,2
        [0,1,2,3,5]
     */
    public static int climbStairs(int n) {
        if (n == 1)
            return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
