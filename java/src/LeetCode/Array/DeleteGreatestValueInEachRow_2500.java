//https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
package LeetCode.Array;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow_2500 {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++)
            Arrays.sort(grid[i]);

        for (int col = 0; col < m; col++) {
            int max = Integer.MIN_VALUE;
            for (int row = 0; row < n; row++)
                max = Math.max(max, grid[row][col]);
            res += max;
        }

        return res;
    }
}
