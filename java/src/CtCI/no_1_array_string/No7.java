package CtCI.no_1_array_string;

public class No7 {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        printMatrix(matrix);
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
        System.out.println(rotate(matrix));
    }

    /*
        (0, 0) -> (0, 3)
        (0, 1) -> (1, 3)
        (0, 2) -> (2, 3)
        (0, 3) -> (3, 3)

        (1, 0) -> (0, 2)
        (1, 1) -> (1, 2)
        (1, 2) -> (2, 2)
        (1, 3) -> (3, 2)

        (2, 0) -> (0, 1)
        (2, 1) -> (1, 1)
        (2, 2) -> (2, 1)
        (2, 3) -> (3, 1)

        (3, 0) -> (0, 0)
        (3, 1) -> (1, 0)
        (3, 2) -> (2, 0)
        (3, 3) -> (3, 0)
     */
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int len = matrix.length;
        for (int layer = 0; layer < len / 2; layer++) {
            int first = layer;
            int last = len - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
        printMatrix(matrix);
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(", ");
            }
            System.out.println("");
        }
    }

    private static int[][] createMatrix() {
        int[][] matrix = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        return matrix;
    }
}
