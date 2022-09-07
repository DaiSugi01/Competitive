package LeetCode.Greedy;

public class MaxIncreaseKeepCitySkyline_807 {
    public static void main(String[] args) {
        MaxIncreaseKeepCitySkyline_807 sol = new MaxIncreaseKeepCitySkyline_807();
        int[][] grid = new int[][]{
                new int[]{3, 0, 8, 4},
                new int[]{2, 4, 5, 7},
                new int[]{9, 2, 6, 3},
                new int[]{0, 3, 1, 0}
        };
        System.out.println(sol.maxIncreaseKeepingSkyline(grid));
    }

    /*
        rowHighest=[8,7,9,3]
        colHighest=[9,4,8,7]
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowHighest = new int[grid[0].length];
        int[] colHighest = new int[grid.length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                rowHighest[r] = Math.max(rowHighest[r], grid[r][c]);
                colHighest[c] = Math.max(colHighest[c], grid[r][c]);
            }
        }

        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans += Math.min(rowHighest[c], colHighest[r]) - grid[r][c];
            }
        }


        return ans;
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
