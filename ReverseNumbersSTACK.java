package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersSTACK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] inputs = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String n: inputs) {
            stack.push(n);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
