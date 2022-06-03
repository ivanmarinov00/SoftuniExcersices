package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String tulipsInput = s.nextLine();
        String daffodilInput = s.nextLine();

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        //stack
        Arrays.stream(tulipsInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);
        //queue
        Arrays.stream(daffodilInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);
        int bouquets = 0;
        int leftFlowers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()){
            int tulip = tulips.peek();
            int daffodil = daffodils.peek();
            int sum = tulip + daffodil;
            if (sum == 15){
                bouquets++;
                tulips.pop();
                daffodils.poll();
            }
            else if (sum > 15){
                tulips.pop();
                tulips.push(tulip -2);
            }
            else {
                tulips.pop();
                daffodils.poll();
                leftFlowers += sum;
            }
        }
        bouquets += leftFlowers/15;
        if (bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquetes", bouquets);
        }
        else {
            System.out.printf("You failed :(. You need %d more bouquets", 5 - bouquets);
        }
    }
}
