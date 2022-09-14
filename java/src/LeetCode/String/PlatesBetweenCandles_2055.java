package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class PlatesBetweenCandles_2055 {
    public static void main(String[] args) {
        PlatesBetweenCandles_2055 sol = new PlatesBetweenCandles_2055();
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{
                new int[]{1, 17},
                new int[]{4, 5},
                new int[]{14, 17},
                new int[]{5, 11},
                new int[]{15, 16}
        };
        int[] a = sol.platesBetweenCandles(s, queries);
        for (int g : a)
            System.out.println(g);
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                candles.add(i);
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int left = binarySearch(candles, 0, candles.size() - 1, q[0], true);
            int right = binarySearch(candles, 0, candles.size() - 1, q[1], false);
            if (left > right) {
                ans[i++] = 0;
            } else {
                ans[i++] = candles.get(right) - candles.get(left) - 1 - (right - left - 1);
            }
        }
        return ans;
    }

    private int binarySearch(List<Integer> candles, int l, int r, int target, boolean isLeft) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (candles.get(mid) == target) {
                return mid;
            } else if (candles.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return isLeft ? l : r;
    }
}
