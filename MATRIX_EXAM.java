package JavaAdvanced;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MATRIX_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();
        String[] data = scanner.nextLine().split("\\s+");
        String vowelsChar = "";
        String consonantsChar = "";
        for (String d : data) {
            vowels.offer(d);
        }
        data = scanner.nextLine().split("\\s+");
        for (String d : data) {
            consonants.push(d);
        }
        int countWord = 0;
        String word1 = "pear";
        String word2 = "flour";
        String word3 = "pork";
        String word4 = "olive";

        List<String> wordArr = new ArrayList<>();
        wordArr.add(word1);
        wordArr.add(word2);
        wordArr.add(word3);
        wordArr.add(word4);
        while (!consonants.isEmpty()) {
            vowelsChar = vowels.peek();
            consonantsChar = consonants.peek();
            if (word1.contains((vowelsChar))) {
                word1 = word1.replace(vowelsChar, "");
            }
            if (word1.contains(consonantsChar)) {
                word1 = word1.replace(consonantsChar, "");
            }
            if (word2.contains(vowelsChar)) {
                word2 = word2.replace(vowelsChar, "");
            }
            if (word2.contains(consonantsChar)) {
                word2 = word2.replace(consonantsChar, "");
            }
            if (word3.contains(vowelsChar)) {
                word3 = word3.replace(vowelsChar, "");
            }
            if (word3.contains(consonantsChar)) {
                word3 = word3.replace(consonantsChar, "");
            }
            if (word4.contains(vowelsChar)) {
                word4 = word4.replace(vowelsChar, "");
            }
            if (word4.contains(consonantsChar)) {
                word4 = word4.replace(consonantsChar, "");
            }
            consonants.pop();
            vowels.poll();
            vowels.offer(vowelsChar);
        }
        if (word1.equals("")) {
            countWord++;
        } else {
            wordArr.remove("pear");
        }
        if (word2.equals("")) {
            countWord++;
        } else {
            wordArr.remove("flour");
        }
        if (word3.equals("")) {
            countWord++;
        } else {
            wordArr.remove("pork");
        }
        if (word4.equals("")) {
            countWord++;
        } else {
            wordArr.remove("olive");
        }
        System.out.printf("Words found: %d %n", countWord);
        for (String s : wordArr) {
            System.out.println(s);
        }
    }
}
