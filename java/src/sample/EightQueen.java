package sample;

public class EightQueen {
    /*
        [
            [1990, 1999],
            [1993, 2000],
            [1995, 2000],
            [2003, 2004],
            [2005, 2010]
        ]

        [
            [1990, 1999],
            [1993, 2000],
            [1995, 2000],
            [2005, 2010],
            [2003, 2004]
        ]
     */
    int ans = 0;

    public static void main(String[] args) {
        EightQueen sol = new EightQueen();
        char[][] a = new char[][]{
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        };
//        sol.printBoard(a);
        sol.eightQueen();
    }

    int eightQueen() {
        char[][] board = new char[8][8];
        queen(0, board);
        return ans;
    }

    void queen(int n, char[][] board) {
        if (n == board.length) {
            ans++;
            printBoard(board);
            return;
        }

        for (int i = n; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!valid(j, board)) continue;
                board[i][j] = 'O';
                queen(i + 1, board);
                board[i][j] = 'X';
            }

        }
    }

    private boolean valid(int col, char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            if (row != col && board[row][col] == 'O') return false;
        }

        for (int i = 0; i < n; i++) {
            if (i + col >= n) break;
            if (i != col && board[i][i + col] == 'O') return false;
        }

        for (int i = 0; i < n; i++) {
            if (i != col && board[i][n - i - 1] == 'O') return false;
        }

        return true;
    }

    void printBoard(char[][] board) {
        System.out.println("-".repeat(17));
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                if (j < board.length - 1) {
                    System.out.print(" " + board[i][j] + " ");
                    System.out.print("|");
                } else {
                    System.out.println(" " + board[i][j] + " |");
                }
            }
        }
        System.out.println("-".repeat(17));
    }
}
