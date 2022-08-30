package LeetCode.Array;

public class WordSearch_79 {
    static final int[] dy = new int[]{0, 1, 0, -1};
    static final int[] dx = new int[]{1, 0, -1, 0};

    private static boolean dfs(int y, int x, char[][] board, int currentNum, String word) {
        if (currentNum == word.length() - 1)
            return true;

        board[y][x] = '-';

        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isValid(ny, nx, board.length, board[0].length, board, word, currentNum + 1))
                continue;

            if (dfs(ny, nx, board, currentNum + 1, word))
                return true;
        }

        board[y][x] = word.charAt(currentNum);
        return false;
    }

    private static boolean isValid(int y, int x, int yLen, int xLen, char[][] board, String word, int currentNum) {
        return y >= 0 && y < yLen &&
                x >= 0 && x < xLen &&
                board[y][x] == word.charAt(currentNum);
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0))
                    continue;

                if (dfs(i, j, board, 0, word))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'C', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'B', 'C', 'A'}
        };
        String word = "AAB";
        System.out.println(exist(board, word));
    }
}
