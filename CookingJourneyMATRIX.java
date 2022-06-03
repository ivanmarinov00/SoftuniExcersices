package JavaAdvanced;

import java.util.Scanner;

public class CookingJourneyMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            String rowContent = s.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
        int playerRow = 0;
        int playerCol = 0;
        int clientValue;
        int sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'S') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        String[] commands = s.nextLine().split(System.lineSeparator());
        for (String command : commands) {
            matrix[playerRow][playerCol] = '-';
            switch (command) {
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
            }
            if (playerCol < 0 || playerCol >= n || playerRow < 0 || playerRow >= n) {
                break;
            }
            if (Character.isDigit(matrix[playerRow][playerCol])) {
                clientValue = Character.getNumericValue(matrix[playerRow][playerCol]);
                sum += clientValue;
                matrix[playerRow][playerCol] = 'S';
                if (sum < 50){
                    continue;
                }
                else {
                    break;
                }
            }
            if (matrix[playerRow][playerCol] == 'P') {
                matrix[playerRow][playerCol] = '-';
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        char currentElement = matrix[row][col];
                        if (currentElement == 'P') {
                            playerRow = row;
                            playerCol = col;
                            matrix[playerRow][playerCol] = 'S';
                        }
                    }
                }
            }
        }
        if (sum >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        else {
            System.out.println("Bad news! You are out of the pastry shop.");
            matrix[playerRow][playerCol] = '-';
        }
        System.out.printf("Money: %d%n", sum);
        for (int row = 0; row < n; row++) {
                System.out.println(matrix[row]);
        }
    }
}

