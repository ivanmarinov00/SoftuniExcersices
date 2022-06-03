package SoftUniExamPrep;

import java.util.Scanner;

public class StringManipulatorSTRING {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("End")){
            String [] commandData = command.split(" ");
            switch (commandData[0]){
                case "Translate" :
                    String text = "";
                    String ch = commandData[1];
                    String replacement = commandData[2];
                    if (input.toString().contains(ch)){
                        text = input.toString().replaceAll(ch,replacement);
                        input.delete(0,input.length());
                        input.append(text);
                    }
                    System.out.println(input);
                    break;
                case "Includes" :
                    String substring = commandData[1];
                    if (input.toString().contains(substring)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start" :
                    substring = commandData[1];
                    if (input.indexOf(substring) == 0){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase" :
                    text = input.toString().toLowerCase();
                    input.delete(0,input.length());
                    input.append(text);
                    System.out.println(input);
                    break;
                case "FindIndex" :
                    ch = commandData[1];
                    int index = input.lastIndexOf(ch);

                    System.out.println(index);
                    break;
                case "Remove" :
                    int startIndex = Integer.parseInt(commandData[1]);
                    int count = Integer.parseInt(commandData[2]);
                    input.replace(startIndex,startIndex + count , "");
                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
