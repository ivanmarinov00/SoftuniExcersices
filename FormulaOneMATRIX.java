package JavaAdvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormulaOneMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[n][n];
        int i = Integer.parseInt(s.nextLine());
        List<String> commands = new ArrayList<>();
        int playerRow = 0;
        int playerCol = 0;
        boolean finish = false;

            for (int row = 0; row < n; row++) {
                String rowContent = s.nextLine();
                char[] rowSymbols = rowContent.toCharArray();
                matrix[row] = rowSymbols;
            }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentCor = matrix[row][col];
                if (currentCor == 'P'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        for (int j = 0; j < i; j++) {
            String comms = s.nextLine();
            commands.add(comms);
            matrix[playerRow][playerCol] = '.';
            switch (commands.get(j)){
                case "up":
                        playerRow--;
                        playerRow = rowOutOfBounds(playerRow,n);
                    if (matrix[playerRow][playerCol] == 'B'){
                        playerRow--;
                        playerRow = rowOutOfBounds(playerRow,n);
                    }
                    if (matrix[playerRow][playerCol] == 'T'){
                        playerRow++;
                        playerRow = rowOutOfBounds(playerRow,n);
                    }
                    break;

                case "down":
                        playerRow++;
                    playerRow = rowOutOfBounds(playerRow,n);
                    if (matrix[playerRow][playerCol] == 'B'){
                        playerRow++;
                        playerRow = rowOutOfBounds(playerRow,n);
                    }
                    if (matrix[playerRow][playerCol] == 'T'){
                        playerRow = rowOutOfBounds(playerRow,n);
                    }
                    break;

                case "left":
                        playerCol--;
                    playerCol = colOutOfBounds(playerCol,n);
                    if (matrix[playerRow][playerCol] == 'B'){
                        playerCol--;
                        playerCol = colOutOfBounds(playerCol,n);
                    }
                    if (matrix[playerRow][playerCol] == 'T'){
                        playerCol++;
                        playerCol = colOutOfBounds(playerCol,n);
                    }
                    break;

                case "right":
                        playerCol++;
                    playerCol = colOutOfBounds(playerCol,n);
                    if (matrix[playerRow][playerCol] == 'B'){
                        playerCol++;
                        playerCol = colOutOfBounds(playerCol,n);
                    }
                    if (matrix[playerRow][playerCol] == 'T'){
                        playerCol--;
                        playerCol = colOutOfBounds(playerCol,n);
                    }
                    break;
            }
            if (matrix[playerRow][playerCol] == 'F'){
                matrix[playerRow][playerCol] ='P';
                finish = true;
                break;
            }
            matrix[playerRow][playerCol] ='P';
        }
        if (finish){
            System.out.println("Well done, the player won first place!");
        }
        else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int row = 0; row < n; row++) {
            System.out.println(matrix[row]);
        }
        System.out.println();
    }
    public static int rowOutOfBounds(int playerRow, int n){
        if (playerRow < 0){
            playerRow = n-1;
        }
        else if (playerRow >= n){
            playerRow = 0;
        }
        return playerRow;
    }
    public static int colOutOfBounds(int playerCol, int n){
        if (playerCol < 0){
            playerCol = n-1;
        }
        else  if (playerCol >= n){
            playerCol = 0;
        }
        return playerCol;
    }
}

