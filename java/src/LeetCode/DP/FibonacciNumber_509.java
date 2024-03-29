package LeetCode.DP;

public class FibonacciNumber_509 {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }

    public static int fib2(int n) {
        int[] dp = new int[30];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib(int n) {
        if (n <= 1) return n;

        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    public static int fibIteration(int n) {
        if (n <= 1) return n;

        int prev1 = 1;
        int prev2 = 0;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
