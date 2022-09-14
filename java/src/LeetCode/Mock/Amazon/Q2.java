package LeetCode.Mock.Amazon;

public class Q2 {
    /*
        [1, 2, 3, 4]
        [16,15,14,5]
        [11,12,13,6]
        [10, 9, 8,7]
     */
    boolean[][] checked;
    int[][] res;

    public int[][] generateMatrix(int n) {
        checked = new boolean[n][n];
        res = new int[n][n];
        res[0][0] = 1;
        checked[0][0] = true;
        dfs(0, 0, 1, n);
        return res;
    }

    private void dfs(int y, int x, int count, int n) {
        if (count == n * n)
            return;
        checked[y][x] = true;
        res[y][x] = count;

        if (x < n && isValid(y, x + 1, n) && !checked[y][x + 1]) dfs(y, x + 1, count + 1, n);
        if (y < n && isValid(y + 1, x, n) && !checked[y + 1][x]) dfs(y + 1, x, count + 1, n);
        if (x >= 0 && isValid(y, x - 1, n) && !checked[y][x - 1]) dfs(y, x - 1, count + 1, n);
        if (y >= 0 && isValid(y - 1, x, n) && !checked[y - 1][x]) dfs(y - 1, x, count + 1, n);
    }

    private boolean isValid(int y, int x, int n) {
        return y >= 0 && y < n &&
                x >= 0 && x < n;
    }
}
