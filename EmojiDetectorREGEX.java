package SoftUniExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetectorREGEX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        Pattern pattern = Pattern.compile("([*]{2}|[:]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)");
        Matcher m = pattern.matcher(text);
        int coolSum = 1;

        for (char symbol : text.toCharArray()
        ) {
            if (Character.isDigit(symbol)) {
                coolSum *= Integer.parseInt(symbol + "");
            }
        }
        System.out.printf("Cool threshold: %d", coolSum);
        int countValidEmoji = 0;
        List<String> coolEmoji = new ArrayList<>();
        while (m.find()) {
            countValidEmoji++;
            int emojiSum = 0;
            String emoji = m.group("emoji");
            for (char symbol : emoji.toCharArray()) {
                emojiSum += (int) symbol;
            }
            if (emojiSum > coolSum) {
                coolEmoji.add(emoji);
            }
            System.out.printf("%d emojis found in the text. The cool ones are:", countValidEmoji);
            coolEmoji.forEach(e -> System.out.println(emoji));
        }
    }
}

