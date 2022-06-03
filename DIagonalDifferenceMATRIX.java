package JavaAdvanced;

import java.util.Scanner;

public class DIagonalDifferenceMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] matrix = new int[n][n];
        fillMatrix(matrix, s);
        int sumFirst = getSumPrimDaig(matrix);
        int sumSecond = getSumSecDiag(matrix);
        System.out.println(Math.abs(getSumPrimDaig(matrix) - getSumSecDiag(matrix)));
    }

    private static int getSumSecDiag(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currElem = matrix[row][col];
                if (col == matrix.length - row - 1){
                    sum += currElem;
                }
            }
        }
        return sum;
    }

    private static int getSumPrimDaig(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int curElement = matrix[row][col];
                if (row == col){
                    sum += curElement;
                }
            }
        }
        return  sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner s) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = s.nextInt();
            }
        }
    }
}
