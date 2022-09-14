package LeetCode.BFSDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RottingOranges_994 {
    int days = 0;
    int[] dy = new int[]{0, 1, 0, -1};
    int[] dx = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        RottingOranges_994 sol = new RottingOranges_994();
        System.out.println(sol.orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{0, 1, 1},
                new int[]{1, 0, 1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    squares.add(new Square(i, j));
                }
            }
        }

        bfs(squares, grid);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return days;
    }

    private void bfs(List<Square> square, int[][] grid) {
        Queue<List<Square>> q = new ArrayDeque<>();
        q.add(square);

        while (!q.isEmpty()) {
            List<Square> squares = q.poll();
            List<Square> nextSq = new ArrayList<>();

            for (Square s : squares) {
                for (int i = 0; i < dx.length; i++) {
                    int ny = s.y + dy[i];
                    int nx = s.x + dx[i];

                    if (!isValid(ny, nx, grid))
                        continue;

                    grid[ny][nx] = 2;
                    nextSq.add(new Square(ny, nx));
                }
            }
            if (!nextSq.isEmpty()) {
                q.add(nextSq);
                days++;
            }
        }
    }

    private boolean isValid(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length &&
                x >= 0 && x < grid[0].length &&
                grid[y][x] == 1;
    }

    class Square {
        int y;
        int x;

        public Square(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
