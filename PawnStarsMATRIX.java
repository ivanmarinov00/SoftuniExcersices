package JavaAdvanced;

import java.util.Scanner;

public class PawnStarsMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        int whiteRow = 0;
        int blackRow = 0;
        int whiteCol = 0;
        int blackCol = 0;
        boolean gameActive = true;

        for (int row = 0; row < 8; row++) {
            String rowContent = s.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char currentCor = matrix[row][col];
                if (currentCor == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                }
                if (currentCor == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }
        while (gameActive) {
            matrix[whiteRow][whiteCol] = '-';
            //if white takes black
            if (isInBounds(whiteRow-1, whiteCol-1) && matrix[whiteRow - 1][whiteCol - 1] == 'b') {
                matrix[whiteRow - 1][whiteCol - 1] = 'w';
                String position = SetPosition(whiteRow - 1, whiteCol - 1);
                System.out.printf("Game over! White capture on %s.", position);
                gameActive = false;
            }
            //if white takes black
            else if (isInBounds(whiteRow-1, whiteCol+1)&& matrix[whiteRow - 1][whiteCol + 1] == 'b') {
                matrix[whiteRow - 1][whiteCol + 1] = 'w';
                String position = SetPosition(whiteRow - 1, whiteCol + 1);
                System.out.printf("Game over! White capture on %s.", position);
                gameActive = false;
            } else {
                matrix[whiteRow - 1][whiteCol] = 'w';
                whiteRow = whiteRow - 1;
                if (whiteRow == 0) {
                    String position = SetPosition(whiteRow, whiteCol);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
                    gameActive = false;
                }
            }
            matrix[blackRow][blackCol] = '-';
            //if black takes white
            if (isInBounds(blackRow+1, blackCol -1)&& matrix[blackRow + 1][blackCol - 1] == 'w') {
                matrix[blackRow + 1][blackCol - 1] = 'b';
                String position = SetPosition(blackRow + 1, blackCol - 1);
                System.out.printf("Game over! Black capture on %s.", position);
                gameActive = false;
            }
            //if black takes white
            else if (isInBounds(blackRow+1, blackCol+1)&& matrix[blackRow + 1][blackCol + 1] == 'w') {
                matrix[blackRow + 1][blackCol + 1] = 'b';
                String position = SetPosition(blackRow + 1, blackCol + 1);
                System.out.printf("Game over! Black capture on %s.", position);
                gameActive = false;
            } else {
                matrix[blackRow + 1][blackCol] = 'b';
                blackRow = blackRow + 1;
                if (blackRow == 7) {
                    String position = SetPosition(blackRow, blackCol);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
                    gameActive = false;
                }
            }
        }
    }
    private static String SetPosition(int row, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 8; i >= 0; i--) {
            if (col == i) {
                sb.append((char)(i + 97));
            }
        }

        int counter = 8;
        for (int i = 0; i < 8; i++) {
            if (row == i)
            {
                sb.append(counter);
            }
            counter--;
        }
        return sb.toString();
    }
    private static boolean isInBounds(int row,int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }
}