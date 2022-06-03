package JavaAdvanced;

import java.util.Scanner;

public class MouseAndCheeseMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char [][] matrix = new char[n][n];
        int mouseRow = 0;
        int mouseCol = 0;
        int cheeseCount = 0;
        fillMatrix(s, n, matrix);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentCor = matrix[row][col];
                if (currentCor == 'M'){
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        String direction = s.nextLine();
        while (!direction.equals("end")){
            matrix[mouseRow][mouseCol] = '-';
            switch (direction){
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow ++;
                    break;
                case"left":
                    mouseCol--;
                    break;
                case"right":
                    mouseCol++;
                    break;
            }
            if (mouseCol < 0 || mouseCol >= n || mouseRow < 0 || mouseRow >= n){
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseCol] == 'c'){
                cheeseCount++;

            }
            else if (matrix[mouseRow][mouseCol] == 'B'){
                continue;
            }
            matrix[mouseRow][mouseCol] = 'M';
            direction = s.nextLine();
        }
        if (cheeseCount > 5){
            int remainingCheese = 5 - cheeseCount;
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more", remainingCheese);
        }
        else {
            System.out.printf("Great job, the is fed %d cheese", cheeseCount);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.println(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner s, int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String rowContent = s.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
    }
}
