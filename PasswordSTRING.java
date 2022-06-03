package SoftUniExamPrep;


import java.util.Scanner;

public class PasswordSTRING {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String password = s.nextLine();
        String input = s.nextLine();
        while (!input.equals("Complete")){
            String[] commands = input.split(" ");
            String command = commands[0];
            switch (command){
                case"Make":
                    int index = Integer.parseInt(commands[2]);
                    char[] symbols = password.toCharArray();
                    if (commands[1].equals("Upper")){
                            symbols[index] = Character.toUpperCase(symbols[index]);
                    }
                    else {
                            symbols[index] = Character.toLowerCase(symbols[index]);
                    }
                    password=String.valueOf(symbols);
                    System.out.println(password);
                    break;
                case"Insert":
                    int i =Integer.parseInt (commands[1]);
                    char[] v = commands[2].toCharArray();
                    if (i >= 0 && i < password.length()){
                        password = password.substring(0, i) + v[0] + password.substring(i);
                    }
                    System.out.println(password);
                    break;
                case"Replace":
                    char[] t = commands[1].toCharArray();
                    int val = Integer.parseInt(commands[2]);
                    int ascii = (int) t[0];
                    char newChar = (char) (val + ascii);
                    char oldChar = t[0];
                    String o1 = String.valueOf(oldChar);
                    if (password.contains(o1)){
                       password = password.replace(oldChar, newChar);
                    }
                    System.out.println(password);
                    break;
                case "Validation":
                    if (!(password.length() >= 8)){
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    if (!password.matches("[a-zA-Z]+") && !password.matches(".*\\d.*") && !password.contains("_")){
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    if (!containsUpperCaseLetter(password)){
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    if (!containsLowerCaseLetter(password)){
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    if (!password.matches(".*\\d.*")){
                        System.out.println("Password must consist at least one digit!");
                    }
            }
            input = s.nextLine();
        }
    }
    public static boolean containsUpperCaseLetter(String s){
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean containsLowerCaseLetter(String s){
        for(int i=0;i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
