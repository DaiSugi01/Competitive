package LeetCode.BFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaIsland_659 {
    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};
    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxIslands = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    maxIslands = Math.max(maxIslands, bfs(i, j, n, m));

        return maxIslands;
    }

    private int bfs(int y, int x, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        grid[y][x] = 0;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int[] pair = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || grid[ny][nx] == 0) continue;
                grid[ny][nx] = 0;
                q.add(new int[]{ny, nx});
            }
        }

        return count;
    }
}
