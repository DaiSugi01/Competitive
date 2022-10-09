package sample;

import java.util.Arrays;

/*
    https://leetcode.com/discuss/interview-question/2306671/Amazon-or-SDE2
 */
public class Y1 {
    public static void main(String[] args) {
        int[][] deals = new int[][]{
                new int[]{1, 2},
//                new int[]{3, 5},
//                new int[]{7, 9},
        };
        Y1 sol = new Y1();
        System.out.println(sol.getMin(5, deals));
        System.out.println(sol.getMin(35, deals));
        System.out.println(sol.getMin(678, deals));
        System.out.println(sol.getMin(1245, deals));
    }

    private int getMin(int numCandies, int[][] deals) {
        Arrays.sort(deals, (n1, n2) -> n1[0] - n2[0]);
        int res = 0;
        int current = deals.length - 1;
        while (numCandies > 0) {
            while (current > 0 && numCandies < deals[current][0])
                current--;
            res += deals[current][1];
            numCandies -= Math.min(deals[current][0], numCandies);
        }

        return res;
    }
}
