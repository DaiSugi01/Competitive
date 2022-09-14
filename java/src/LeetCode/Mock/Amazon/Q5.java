package LeetCode.Mock.Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q5 {
    public static void main(String[] args) {
        Q5 sol = new Q5();
        System.out.println(sol.kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, 1));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        for (int[] p : points)
            pq.add(p);

        System.out.println(points[0][0] * points[0][0] + points[0][1] * points[0][1]);
        System.out.println(points[1][0] * points[1][0] + points[1][1] * points[1][1]);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty())
                return res;
            res[i] = pq.poll();
        }

        return res;
    }
}
