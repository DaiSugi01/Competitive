package LeetCode.Array;

public class SpiralMatrixII_59 {
    public static void main(String[] args) {
        SpiralMatrixII_59 sol = new SpiralMatrixII_59();
        int[][] res = sol.generateMatrix(5);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(String.valueOf(res[i][j] + ", "));
            }
            System.out.println("");
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            for (int i = layer; i < n - layer; i++) {
                res[layer][i] = count++;
            }

            for (int i = layer + 1; i < n - layer; i++) {
                res[i][n - layer - 1] = count++;
            }

            for (int i = n - layer - 2; i >= layer; i--) {
                res[n - layer - 1][i] = count++;
            }

            for (int i = n - layer - 2; i >= layer + 1; i--) {
                res[i][layer] = count++;
            }
        }

        return res;
    }
}
