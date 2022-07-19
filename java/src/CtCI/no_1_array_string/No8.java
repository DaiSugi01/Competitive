package CtCI.no_1_array_string;

import java.util.Random;

public class No8 {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(4, 3);
        System.out.println("---------- Before ----------");
        printMatrix(matrix);
        setZero(matrix);
        System.out.println("---------- After ----------");
        printMatrix(matrix);
    }

    /*
        Track 0 using row and column array
        loop through row array and set 0 to the row if there is 0
        loop through column array and set 0 to the column if there is 0
     */
    public static void setZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }


    private static int[][] createMatrix(int row, int column) {
        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Random rand = new Random();
                matrix[i][j] = rand.nextInt(10);
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

}
