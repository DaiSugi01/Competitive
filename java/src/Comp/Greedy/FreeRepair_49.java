package Comp.Greedy;

import java.util.PriorityQueue;

public class FreeRepair_49 {
    public static void main(String[] args) {
        System.out.println(solve2(new int[]{5, 15, 2, 10, 7}));
    }

    /*
        [2,5,7,10,15]
        1: [7,7,10,15] -> 7
        2: [10,14,15] -> 21
        3: [15, 24] -> 45
        4: [39] -> 7

     */
    private static int solve2(int[] list) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int l : list) {
            pq.add(l);
        }

        while (pq.size() > 1) {
            int x = pq.poll() + pq.poll();
            ans += x;
            pq.add(x);
        }

        return ans;
    }

    private static int solve(int n, int[] list) {
        int ans = 0;
        while (n > 1) {
            int mii1 = 0;
            int mii2 = 1;
            if (list[mii1] > list[mii2]) {
                int temp = mii1;
                mii1 = mii2;
                mii2 = temp;
            }
            for (int i = 2; i < n; i++) {
                if (list[i] < list[mii1]) {
                    mii2 = mii1;
                    mii1 = i;
                } else if (list[i] < list[mii2]) {
                    mii2 = i;
                }
            }

            int t = list[mii1] + list[mii2];
            ans += t;
            if (mii1 == n - 1) {
                int temp = mii1;
                mii1 = mii2;
                mii2 = temp;
            }
            list[mii1] = t;
            list[mii2] = list[n - 1];
            n--;
        }
        return ans;
    }
}
