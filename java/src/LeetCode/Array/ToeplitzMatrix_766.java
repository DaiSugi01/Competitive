package LeetCode.Array;

import java.util.ArrayDeque;
import java.util.Queue;

public class ToeplitzMatrix_766 {
    final int[] dy = new int[]{-1, 0};
    final int[] dx = new int[]{0, 1};

    public static void main(String[] args) {
        ToeplitzMatrix_766 sol = new ToeplitzMatrix_766();
        sol.isToeplitzMatrix(new int[][]{
                new int[]{11, 74, 0, 93},
                new int[]{40, 11, 74, 7}
        });
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, n - 1));
        visited[n - 1][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int prev = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = pair.x + dx[j];
                    int ny = pair.y + dy[j];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                        if (prev != Integer.MIN_VALUE && matrix[ny][nx] != prev) return false;
                        visited[ny][nx] = true;
                        q.add(new Pair(nx, ny));
                        prev = matrix[ny][nx];
                    }
                }
            }
        }

        return true;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
