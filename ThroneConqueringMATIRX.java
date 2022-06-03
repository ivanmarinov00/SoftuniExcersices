package JavaAdvanced;

import java.util.Scanner;

public class ThroneConqueringMATIRX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int energy = Integer.parseInt(s.nextLine());
        int n = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[n][n];
        int parisRow = 0;
        int parisCol = 0;
        int helenaCol = 0;
        int helenaRow = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            matrix[i] = s.nextLine().toCharArray();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentCor = matrix[row][col];
                if (currentCor == 'P') {
                    parisRow = row;
                    parisCol = col;
                } else if (currentCor == 'H') {
                    helenaRow = row;
                    helenaCol = col;
                }
            }
        }
        while (flag) {
            String input = s.nextLine();
            String[] command = input.split("\\s+");
            int enemyRow = Integer.parseInt(command[1]);
            int enemyCol = Integer.parseInt(command[2]);
            matrix[enemyRow][enemyCol] = 'S';
            matrix[parisRow][parisCol] = '-';
            switch (command[0]) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    energy--;
                    matrix[parisRow][parisCol] = 'P';
                    break;
                case "down":
                    if (parisRow + 1 < n) {
                        parisRow++;
                    }
                    energy--;
                    matrix[parisRow][parisCol] = 'P';
                    break;

                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    energy--;
                    matrix[parisRow][parisCol] = 'P';
                    break;
                case "right":
                    if (parisCol + 1 < n) {
                        parisCol--;
                    }
                    energy--;
                    matrix[parisRow][parisCol] = 'P';
                    break;
            }
            if (enemyRow == parisRow && enemyCol == parisCol) {
                energy -= 2;
            } else if (helenaCol == parisCol && helenaRow == parisRow) {
                matrix[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                flag = false;
            }
            if (energy <= 0){
                playerDead(matrix,parisRow,parisCol);
                flag = false;
            }
        }
        for (int row = 0; row < n; row++) {
            System.out.println(matrix[row]);
        }
        System.out.println();
    }
    private static void playerDead(char[][] matrix, int parisRow, int parisCol) {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
            matrix[parisRow][parisCol] = 'X';
    }
}
