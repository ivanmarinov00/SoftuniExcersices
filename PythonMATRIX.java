package JavaAdvanced;

import java.util.Scanner;

public class PythonMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        char [][] matrix = new char [n][n];
        String [] commands = s.next().split("\\s+");
        for (int row = 0; row < n; row++) {
            matrix[row] = s.nextLine().replaceAll(" ", "").toCharArray();
        }
        int rowPython = 0;
        int colPython = 0;
        int countFood = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 's'){
                    rowPython = row;
                    colPython = col;
                }
               else if (currentElement == 'f'){
                    countFood ++;
                }
            }
        }
        int length = 1;
        boolean isDead = false;
        for (String command: commands) {
            matrix[rowPython][colPython] = '*';
            switch (command){
                case "left":
                    colPython --;
                    break;
                case "right":
                    colPython ++;
                    break;
                case"up":
                    rowPython --;
                    break;
                case"down":
                    rowPython ++;
                    break;
            }
            if (rowPython < 0 || rowPython >= n){
                if (rowPython < 0){
                    rowPython = n - 1;
                }
                 if (rowPython >= n){
                    rowPython = 0;
                }
            }
            else if (colPython < 0 || colPython >= n){
                if (colPython < 0){
                    colPython = n -1;
                }
                 if (colPython >= n){
                    colPython = 0;
                }
            }

            if (matrix[rowPython][colPython] == 'f'){
                length ++;
                countFood --;
            }
            if (countFood == 0) {
                break;
            }
            if (matrix[rowPython][colPython] == 'e'){
                isDead = true;
                break;
            }
            matrix[rowPython][colPython] = 's';
        }
        if (countFood == 0){
            System.out.printf("You win! The python ate all the food. Python length is %d",length);
        }
        else if (isDead){
            System.out.println("Game over! You were killed by an enemy");
        }
        else {
            System.out.printf("You lose! There is still %d food to be eaten", countFood);
        }
    }
}
