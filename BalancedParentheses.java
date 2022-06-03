package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        boolean flag = false;

        ArrayDeque<Character> par = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char curPar = input.charAt(i);
            if (curPar == '{' || curPar == '[' || curPar == '('){
                par.push(curPar);
            }
            else if (curPar == '}' || curPar == ']' || curPar == ')'){
                char lastOpen = par.pop();
                if (curPar == '}' && lastOpen == '{') {
                    //balance
                    flag = true;
                }
                else if (curPar == ']' && lastOpen == '['){
                    flag = true;
                }
                else if (curPar == ')' && lastOpen == '('){
                    flag = true;
                }
                else {
                    //no balance
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
