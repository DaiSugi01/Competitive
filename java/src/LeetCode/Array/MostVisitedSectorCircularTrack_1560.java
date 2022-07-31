package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorCircularTrack_1560 {
    public static void main(String[] args) {
//        mostVisited(4, new int[]{1, 3, 1, 2});
        System.out.println(mostVisited(3, new int[]{3, 1}));
    }

    /*
        if start point >= endpoint --->>> return from start point to endpoint
        if start point < endpoint --->>> return from start point to endpoint

        Case 1: Input: n = 4, rounds = [1,3,3,3] output: [1,2,3]
        1 --> 2 --> 3 --> 4 --> 1 --> 2 --> 3 --> 4 --> 1 --> 2 --> 3

        Case 2: Input: n = 4, rounds = [3,4,3,2]   output: [1,2,3,4]
        3 --> 4 --> 1 --> 2 --> 3 --> 4 --> 1 --> 2
     */
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int len = rounds.length - 1;
        int startPoint = rounds[0];
        int lastPoint = rounds[len];
        for (int i = startPoint; i < lastPoint; i++)
            res.add(i);
        if (!res.isEmpty())
            return res;
        for (int i = 1; i <= lastPoint; i++)
            res.add(i);
        for (int i = startPoint; i <= n; i++)
            res.add(i);

        return res;
    }
}
