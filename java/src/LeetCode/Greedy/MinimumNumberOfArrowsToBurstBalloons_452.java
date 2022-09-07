package LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    /*
        Input: points = [[10,16],[2,8],[1,6],[7,12]]
        Output: 2

        [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
        [[0,6],[2,8],[3,8],[6,8],[0,9],[2,9],[3,9],[3,9],[9,10],[7,12]]
     */
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        pq.add(points[0][1]);
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pq.peek())
                pq.add(points[i][1]);
        }

        return pq.size();
    }
}
