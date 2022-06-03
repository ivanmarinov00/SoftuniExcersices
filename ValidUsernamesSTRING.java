package SoftUniExamPrep;

import java.util.Scanner;

public class ValidUsernamesSTRING {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String u = scanner.nextLine();

        String[] usernames = u.split(", ");

        for (String t:usernames) {
            if (isValidUsername(t)){
                System.out.println(t);
            }
        }
    }

    private static boolean isValidUsername(String t) {
        if (t.length() < 3 || t.length() > 16){
            return false;
        }
        for (char s:t.toCharArray()) {
            if (!(s == '-' || s == '_' || Character.isLetterOrDigit(s))){
                return false;
            }
        }
        return true;
    }
}
