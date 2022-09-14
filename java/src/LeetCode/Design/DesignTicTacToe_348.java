package LeetCode.Design;

public class DesignTicTacToe_348 {
    class TicTacToe {
        int[][] board;

        public TicTacToe(int n) {
            board = new int[n][n];
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;

            if (checkRow(col, player) ||
                    checkCol(row, player) ||
                    (row == col && checkDiagonal(player)) ||
                    (col == board.length - row - 1 && checkAntiDiagonal(player)))
                return player;

            return 0;
        }

        private boolean checkAntiDiagonal(int player) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - i - 1] != player) {
                    return false;
                }
            }

            return true;
        }

        private boolean checkDiagonal(int player) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkCol(int row, int player) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkRow(int col, int player) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != player) {
                    return false;
                }
            }
            return true;
        }
    }
}
