package LeetCode.Array;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {
    /*
        Input: points = [[1,3],[-2,2]], k = 1
        Output: [[-2,2]]
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) ->
                (n1[0] * n1[0] + n1[1] * n1[1]) - (n2[0] * n2[0] + n2[1] * n2[1]));
        for (int i = 0; i < points.length; i++)
            pq.add(points[i]);

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
