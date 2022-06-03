package SoftUniExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Yes2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile("([\\W+\\w\\d]+)>(?<firstGroup>[0-9]{3})\\|(?<secondGroup>[a-z]{3})\\|(?<thirdGroup>[A-Z]{3})\\|(?<forthGroup>[^<>]{3})<\\1");
        Pattern z = Pattern.compile("(.+)>(?<firstGroup>\\d{3})\\|(?<secondGroup>[a-z]{3})\\|(?<thirdGroup>[A-Z]{3})\\|(?<forthGroup>[^<>]{3})<(\\1)");
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String password = s.nextLine();
            Matcher m = z.matcher(password);
            if (m.find()){
                String passwords = m.group("firstGroup") + m.group("secondGroup") + m.group("thirdGroup") + m.group("forthGroup");
                System.out.printf("Password: %s%n",passwords);
            }
            else {
                System.out.println("Try another password!");
            }
        }
    }
}
