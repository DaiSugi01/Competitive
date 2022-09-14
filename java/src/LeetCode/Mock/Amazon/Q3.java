package LeetCode.Mock.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[]{};
        int[] copy = arr.clone();
        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        map.put(copy[0], rank);

        for (int i = 1; i < arr.length; i++) {
            if (copy[i] != copy[i - 1])
                rank++;
            map.put(copy[i], rank);
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
