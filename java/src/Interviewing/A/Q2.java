package Interviewing.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(findTotalPower(new ArrayList<>(Arrays.asList(2, 3, 2, 1))));
    }

    public static int findTotalPower(List<Integer> power) {
        if (power.size() == 0) return 0;

        int n = power.size();
        List<Integer> sums = new ArrayList<>();
        sums.add(power.get(0));
        for (int i = 1; i < n; i++) {
            sums.add(power.get(i) + sums.get(i - 1));
        }

//        int[][] mins = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(mins[i], Integer.MAX_VALUE);
//        }
//        mins[0][0] = power.get(0);
//        for (int i = 1; i < n; i++) {
//            mins[0][i] = Math.min(power.get(i), mins[0][i - 1]);
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                mins[i][j] = Math.min(power.get(j), mins[i][j - 1]);
//            }
//        }
/*
    [2,3,2,1]
    [2,2,1,1]
 */
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums.get(j);
                if (j > 0 && i > 0)
                    sum = sums.get(j) - sums.get(i - 1);
                ans += test(power.subList(i, j + 1)) * sum;
            }
        }

        return (int) (ans % (int) (Math.pow(10, 9) + 7));
    }

    private static int test(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int n : list) {
            min = Math.min(n, min);
        }
        return min;
    }

    public static int findTotalPower2(List<Integer> power) {
        if (power.size() == 0) return 0;

        int n = power.size();
        List<Integer> sums = new ArrayList<>();
        sums.add(power.get(0));
        for (int i = 1; i < n; i++) {
            sums.add(power.get(i) + sums.get(i - 1));
        }
/*
    [2,3,2,1]
    [2,2,1,1]
 */
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums.get(j);
                if (j > 0 && i > 0)
                    sum = sums.get(j) - sums.get(i - 1);
                ans += test(power.subList(i, j + 1)) * sum;
            }
        }

        return ans % (int) (Math.pow(10, 9) + 7);
    }
}
