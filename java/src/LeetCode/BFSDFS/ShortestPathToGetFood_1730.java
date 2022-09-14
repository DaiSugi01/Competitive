package LeetCode.BFSDFS;

import java.util.*;

public class ShortestPathToGetFood_1730 {
    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};
    boolean[][] checked;

    public static void main(String[] args) {
        ShortestPathToGetFood_1730 sol = new ShortestPathToGetFood_1730();
        System.out.println(sol.getFood(new char[][]{
                new char[]{'X', 'X', 'X', 'X', 'X', 'X'},
                new char[]{'X', '*', 'O', 'O', 'O', 'X'},
                new char[]{'X', 'O', 'O', '#', 'O', 'X'},
                new char[]{'X', 'X', 'X', 'X', 'X', 'X'}
//                new char[]{'0', '*'},
//                new char[]{'#', '0'}
        }));

        List<String> orders = new ArrayList<>(Arrays.asList("QA", "fe", "YV"));

        Collections.sort(orders);
        for (String s : orders)
            System.out.println(s);
    }

    public int getFood(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        checked = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '*')
                    return bfs(i, j, grid);

        return -1;
    }

    private int bfs(int y, int x, char[][] grid) {
        int steps = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(y, x)));

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> p = q.poll();
            while (size-- > 0) {
                y = p.get(0);
                x = p.get(1);
                if (grid[y][x] == '#')
                    return steps;

                for (int i = 0; i < dx.length; i++) {
                    int ny = dy[i] + y;
                    int nx = dx[i] + x;
                    if (ny < 0 || ny >= grid.length || nx < 0 ||
                            nx >= grid[0].length || checked[ny][nx] ||
                            grid[ny][nx] == 'X')
                        continue;

                    checked[ny][nx] = true;
                    q.add(new ArrayList<>(Arrays.asList(ny, nx)));
                }
            }
            steps++;
        }

        return -1;
    }

    class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
