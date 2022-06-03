package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperationsSTACK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //String[] input = sc.nextLine().split("\\s+");

        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
            if (stack.contains(x)){
                System.out.println("true");
            }
            else {
                 if (!stack.isEmpty()){
                     System.out.println(Collections.min(stack));
                 }
                 else {
                     System.out.println(0);
                 }
        }
    }
}
