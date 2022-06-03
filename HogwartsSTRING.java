package SoftUniExamPrep;

import java.util.Scanner;

public class HogwartsSTRING {

    private static boolean isValidIndex(int index, String spell) {
        return (index >= 0 && index < spell.length());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String spell = sc.nextLine();

        String input = sc.nextLine();
        while(!input.equals("Abracadabra")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch(command) {
                case "Abjuration":
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(tokens[1]);
                    char letter = tokens[2].charAt(0);

                    if (isValidIndex(index, spell)) {
                        char[] spellCharArray = spell.toCharArray();
                        spellCharArray[index] = letter;
                        spell = String.valueOf(spellCharArray);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String firstSubstring = tokens[1];
                    String secondSubstring = tokens[2];

                    spell = spell.replaceAll(firstSubstring, secondSubstring);
                    System.out.println(spell);
                    break;
                case "Alteration":
                    String subString = tokens[1];

                    spell = spell.replaceAll(subString, "");
                    System.out.println(spell);
                    break;
                default:
                    System.out.println("The spell did not work!");
            }

            input = sc.nextLine();
        }

    }
}

