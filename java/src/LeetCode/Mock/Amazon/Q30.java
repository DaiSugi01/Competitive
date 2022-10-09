package LeetCode.Mock.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q30 {
    int[][] board;

    public static void main(String[] args) {
        Q30 sol = new Q30();
        sol.snakesAndLadders(new int[][]{
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 35, -1, -1, 13, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 15, -1, -1, -1, -1}});
    }

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        int n = board.length;
        int m = board[0].length;

        int step = board.length * board[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        int[][] steps = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(steps[i], n - i);
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    map.put(step--, new int[]{i, j});
                }
            } else {
                for (int j = board[0].length - 1; j >= 0; j--) {
                    map.put(step--, new int[]{i, j});
                }
            }
        }

        dfs(steps, map, 1);

        return 1;
    }

    private void dfs(int[][] steps, Map<Integer, int[]> map, int start) {
        int n = board.length * board[0].length;
        int[] coordinate = map.get(start);
        for (int i = coordinate[0]; i < n; i++) {
            for (int j = coordinate[1]; j < Math.min(coordinate[1] + 6, n); j++) {
                if (board[i][j] == -1)
                    continue;

                int[] coo = map.get(board[i][j]);
                int nr = coo[0];
                int nc = coo[1];
                steps[nr][nc] = Math.min(steps[i][j] + 1, steps[nr][nc]);
                dfs(steps, map, board[i][j]);
            }
        }
    }
}
