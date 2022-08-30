package Comp.Greedy;

import java.util.ArrayList;
import java.util.List;

public class SarumanArmy_47 {
    public static void main(String[] args) {
//        int[] points = new int[]{1, 7, 15, 20, 30, 50};
        int[] points = new int[]{1, 11, 12, 23, 31, 50};
        System.out.println(solve(10, points));
    }

    /*
        input=[1,7,15,20,30,50]
        output=3   -> 1, 20, 50

        start from the left item
        loop through while item <= start + the range (i++)
        input[i-1] should be the far point
        ans++;
     */
    private static List<Integer> solve(int range, int[] points) {
        int len = points.length;

        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < len) {
            int start = points[i++];
            i = movePointer(len, range, i, start, points);
            ans.add(points[i - 1]);
            i = movePointer(len, range, i, points[i - 1], points);
        }

        return ans;
    }

    private static int movePointer(int len, int range, int i, int start, int[] points) {
        while (i < len && points[i] <= start + range) {
            i++;
        }
        return i;
    }
}
