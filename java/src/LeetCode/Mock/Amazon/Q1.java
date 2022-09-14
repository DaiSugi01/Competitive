package LeetCode.Mock.Amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q1 {
    int[] dy = new int[]{0, 1, 0, -1};
    int[] dx = new int[]{1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int count = 0;

            for (int i = 0; i < size; i++) {
                int[] item = q.poll();
                int y = item[0];
                int x = item[1];

                for (int j = 0; j < dx.length; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && grid[ny][nx] == 1) {
                        grid[ny][nx] = 2;
                        q.add(new int[]{ny, nx});
                        count++;
                    }
                }
            }
            if (count > 0)
                res++;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return -1;

        return res;
    }
}
