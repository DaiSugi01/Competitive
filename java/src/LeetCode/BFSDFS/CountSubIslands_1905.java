package LeetCode.BFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountSubIslands_1905 {
    boolean[][] visited;
    int[] yDir = new int[]{-1, 0, 1, 0};
    int[] xDir = new int[]{0, 1, 0, -1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1.length != grid2.length || grid1[0].length != grid2[0].length) return 0;
        int m = grid1.length;
        int n = grid1[0].length;

        visited = new boolean[m][n];
        int numOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    if (bfs(i, j, grid1, grid2))
                        numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }

    private boolean bfs(int y, int x, int[][] grid1, int[][] grid2) {
        boolean flag = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            if (grid1[pair[0]][pair[1]] == 0)
                flag = false;

            for (int i = 0; i < 4; i++) {
                int ny = pair[0] + yDir[i];
                int nx = pair[1] + xDir[i];
                if (!valid(ny, nx, grid1, grid2))
                    continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }

        return flag;
    }

    private boolean valid(int ny, int nx, int[][] grid1, int[][] grid2) {
        return ny >= 0 && ny < grid1.length &&
                nx >= 0 && nx < grid1[0].length &&
                grid2[ny][nx] == 1 &&
                !visited[ny][nx];
    }
}
