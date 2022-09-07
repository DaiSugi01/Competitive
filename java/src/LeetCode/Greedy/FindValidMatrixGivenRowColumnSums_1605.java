package LeetCode.Greedy;

public class FindValidMatrixGivenRowColumnSums_1605 {
    public static void main(String[] args) {
        FindValidMatrixGivenRowColumnSums_1605 sol = new FindValidMatrixGivenRowColumnSums_1605();
        System.out.println(sol.restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8}));
    }

    /*
        Input: rowSum = [5,7,10], colSum = [8,6,8]
        Output: [[0,5,0],
                 [6,1,0],
                 [2,0,8]]

        Input: rowSum = [0,4,10], colSum = [3,6,8]
        Output: [[5,0,0],
                 [3,0,0],
                 [0,0,0]]
     */
    public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = Math.min(row[i], col[j]);
                row[i] -= A[i][j];
                col[j] -= A[i][j];
            }
        }
        return A;
    }
}
