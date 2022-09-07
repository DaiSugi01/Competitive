package LeetCode.Array;

public class GameOfLife_289 {
    public static void main(String[] args) {
        GameOfLife_289 sol = new GameOfLife_289();
        int[][] board = new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0}
        };
        sol.gameOfLife(board);
        System.out.println(board);
    }

    public void gameOfLife(int[][] board) {
        final int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        final int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int n = board.length;
        int m = board[0].length;
        boolean[][] prevState = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int liceCell = 0;
                for (int k = 0; k < dx.length; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (!isValid(ny, nx, n, m, board))
                        continue;

                    if ((board[ny][nx] == 1 && !prevState[ny][nx]) || (board[ny][nx] == 0 && prevState[ny][nx]))
                        liceCell++;
                }

                if (board[y][x] == 1) {
                    if ((liceCell < 2 || liceCell > 2) && liceCell != 3) {
                        board[y][x] = 0;
                        prevState[y][x] = true;
                    }
                } else {
                    if (liceCell == 3) {
                        board[y][x] = 1;
                        prevState[y][x] = true;
                    }
                }
            }
        }
    }

    private boolean isValid(int y, int x, int n, int m, int[][] board) {
        return y >= 0 && y < n &&
                x >= 0 && x < m;
    }
}
