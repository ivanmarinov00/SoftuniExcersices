package JavaAdvanced;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i =Integer.parseInt(s.nextLine().split(", ")[0]);
        String p =s.nextLine().split(", ")[1];
        int [][]matrix = new int[i][i];

        if (p.equals("A")){
            fillMatrixPatternA(matrix);
        }
        else if (p.equals("B")){
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.println(matrix[row][col] + " ");
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 0;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber ++;
                }
            }
            else {
                for (int row = matrix.length -1 ; row >- 0 ; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
