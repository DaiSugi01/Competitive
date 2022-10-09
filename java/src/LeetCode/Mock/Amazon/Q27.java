package LeetCode.Mock.Amazon;

import java.util.Arrays;

public class Q27 {
    public static void main(String[] args) {
        Q27 sol = new Q27();
        int[][] inp1 = new int[][]{
                new int[]{0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 0},
                new int[]{1, 1, 0, 1, 1},
                new int[]{0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        System.out.println(sol.shortestDistance(inp1, start, destination));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0], y - dir[1]}, distance);
            }
        }
    }
}
