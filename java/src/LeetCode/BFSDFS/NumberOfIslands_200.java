package LeetCode.BFSDFS;

import java.util.Stack;

public class NumberOfIslands_200 {

    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};


    public static void main(String[] args) {
        char[][] arr = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        NumberOfIslands_200 a = new NumberOfIslands_200();
        System.out.println(a.numIslands(arr));
    }

    /*
        1,1,0
        0,0,0
        1,1,0
        loop through the array
            search for the island using DFS if the target is 1 (island) & we've not visited there.
            After DFS, count up the response variable.
     */
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numOfIsland = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && !visited[y][x]) {
                    dfs(y, x, visited, grid);
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }

    /*
        110
        101
        110

        true, true, false
        true, false, false
        true, true, false
     */
    private void dfs3(int y, int x, char[][] grid) {
        if (grid[y][x] == '0')
            return;
        grid[y][x] = '0';

        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isIsland(ny, nx, grid))
                dfs3(ny, nx, grid);
        }
    }

    private void dfs2(int y, int x, boolean[][] visited, char[][] grid) {
        if (visited[y][x])
            return;
        visited[y][x] = true;

        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isIsland(ny, nx, grid) && !visited[ny][nx])
                dfs2(ny, nx, visited, grid);
        }
    }

    private boolean isIsland(int y, int x, char[][] grid) {
        return y >= 0 && y < grid.length &&
                x >= 0 && x < grid[0].length &&
                grid[y][x] == '1';
    }

    private void dfs(int y, int x, boolean[][] visited, char[][] grid) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(y, x));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            visited[pair.y][pair.x] = true;
            for (int i = 0; i < dx.length; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];

                if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length || visited[ny][nx]) {
                    continue;
                }

                if (grid[ny][nx] == '0') continue;
                // stack=[]
                stack.add(new Pair(ny, nx));
            }
        }
    }

    class Pair {
        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
