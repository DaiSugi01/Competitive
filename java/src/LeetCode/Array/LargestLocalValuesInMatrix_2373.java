//https://leetcode.com/problems/largest-local-values-in-a-matrix/description/
package LeetCode.Array;

public class LargestLocalValuesInMatrix_2373 {
    public static void main(String[] args) {
        largestLocal(new int[][]{
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 1, 2, 1, 1},
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1},
        });
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int row = 1; row <= n - 2; row++) {
            int currentCol = 0;
            for (int col = 1; col <= n - 2; col++) {
                res[row - 1][currentCol++] = getMaxIn3x3(grid, row - 1, col - 1);
            }
        }

        return res;
    }

    private static int getMaxIn3x3(int[][] grid, int row, int col) {
        int maxVal = Integer.MIN_VALUE;
        for (int x = row; x < row + 3; x++) {
            for (int y = col; y < col + 3; y++) {
                maxVal = Math.max(maxVal, grid[x][y]);
            }
        }

        return maxVal;
    }
}