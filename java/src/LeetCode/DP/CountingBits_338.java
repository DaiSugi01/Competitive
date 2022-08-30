package LeetCode.DP;

public class CountingBits_338 {
    private static int popCount(int x) {
        int count = 0;
        for (count = 0; x != 0; count++)
            x &= x - 1;

        return count;
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int x = 0;
        for (int i = 0; i < n; i++) {
            res[i] = popCount(i);
        }
        return res;
    }
}
