package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryDEQUEUE {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayDeque<Integer> beverages = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        //queue
        String[] beverageInput = s.nextLine().split("\\s+");
        for (String n: beverageInput) {
            beverages.offer(Integer.parseInt(n));
        }
        //stack
        String[] ingredientsInput = s.nextLine().split("\\s+");
        for (String n: ingredientsInput) {
            ingredients.push(Integer.parseInt(n));
        }
        int biscuitCounter= 0;
        int cakeCounter = 0;
        int pastryCounter = 0;
        int pieCounter = 0;
        while (!ingredients.isEmpty() && !beverages.isEmpty()){
            int ingredientValue = ingredients.peek();
            int beverageValue = beverages.peek();
            int sum = ingredientValue + beverageValue;

            if (sum == 50 || sum == 25 || sum == 75 || sum == 100){
                ingredients.pop();
                beverages.poll();
                if (sum == 50){
                    cakeCounter++;
                }
                else if (sum == 25){
                    biscuitCounter++;
                }
                else if (sum == 75){
                    pastryCounter++;
                }
                else{
                    pieCounter++;
                }
            }
            else {
                beverages.poll();
                int newIngredient = ingredients.peek();
                newIngredient += 3;
                ingredients.pop();
                ingredients.push(newIngredient);
            }
        }
        if (biscuitCounter >=1 && cakeCounter >= 1 && pastryCounter >= 1 && pieCounter >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (beverages.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String output = beverages
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(output);
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            String output = ingredients
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(output);
        }
        System.out.printf("Biscuit: %d%n",biscuitCounter);
        System.out.printf("Cake: %d%n",cakeCounter);
        System.out.printf("Pie: %d%n",pieCounter);
        System.out.printf("Pastry: %d%n",pastryCounter);
    }
}

