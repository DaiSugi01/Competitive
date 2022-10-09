package LeetCode.BFSDFS;

public class SurroundedRegions_130 {
    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};
    boolean[][] visited;
    char[][] board;

    public static void main(String[] args) {
        SurroundedRegions_130 sol = new SurroundedRegions_130();
        char[][] inp = new char[][]{
                new char[]{'O', 'O', 'X', 'X'},
                new char[]{'O', 'O', 'O', 'X'},
                new char[]{'O', 'X', 'O', 'X'},
                new char[]{'O', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'O', 'X', 'X', 'X'},
        };
        sol.solve(inp);

        for (int i = 0; i < inp.length; i++) {
            for (int j = 0; j < inp[0].length; j++) {
                System.out.print(inp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        this.board = board;

        for (int x = 0; x < board[0].length; x++) {
            if (!visited[0][x] && board[0][x] == 'O')
                dfs(0, x);
            if (!visited[board.length - 1][x] && board[board.length - 1][x] == 'O')
                dfs(board.length - 1, x);
        }

        for (int y = 0; y < board.length; y++) {
            if (!visited[y][0] && board[y][0] == 'O')
                dfs(y, 0);
            if (!visited[y][board[0].length - 1] && board[y][board[0].length - 1] == 'O')
                dfs(y, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'E')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int y, int x) {
        visited[y][x] = true;
        board[y][x] = 'E';

        for (int i = 0; i < dy.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length || board[ny][nx] == 'X' || visited[ny][nx])
                continue;

            dfs(ny, nx);
        }
    }

    private boolean isEdge(int x, int y) {
        return (x == 0 || x == board[0].length - 1 || y == 0 || y == board.length - 1);
    }
}
