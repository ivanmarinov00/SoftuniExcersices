package JavaAdvanced;

import java.util.Scanner;

public class TheHeiganDanceMATRIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        float playerDamage = s.nextFloat();
        double HeiganHP = 3000000;
        double PlayerHP = 18500;


        while (HeiganHP > 0 || PlayerHP > 0){
            String[] input = s.nextLine().split(" ");
            String spellType = input[0];
            int rowPos = Integer.parseInt(input[1]);
            int colPos = Integer.parseInt(input[2]);
            int [][] damageMatrix = new int[3][3];
            for (int i = rowPos-1; i >=rowPos +1 ; i++) {
                for (int j = colPos -1; j >= colPos ; j++) {
                    
                }
            }
        }
    }
}
