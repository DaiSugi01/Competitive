package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonElementAllRows_1198 {
    public int smallestCommonElement(int[][] mat) {
        if (mat.length < 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
                if (map.get(mat[i][j]) == mat.length) return mat[i][j];
            }
        }

        return -1;
    }
}
