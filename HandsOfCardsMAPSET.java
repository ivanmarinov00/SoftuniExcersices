package JavaAdvanced;

import java.util.*;

public class HandsOfCardsMAPSET {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Map<String , Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            String[] cardsArr = cards.split(", ");
            Set<String> cardSet = new HashSet<>(Arrays.asList(cardsArr));

            if (!players.containsKey(playerName)){
                players.put(playerName, cardSet);
            }
            else {
                Set<String> currentCards = players.get(playerName);
                currentCards.addAll(cardSet);
                players.put(playerName, currentCards);
            }
            input =s.nextLine();
        }
        players.entrySet().forEach(e -> {
            Set<String> cards = e.getValue();
            System.out.printf("%s: %d%n", e.getKey(), getCardsPoints(cards));
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> symbolVal = getSymbolsValues();
        int sumPoints = 0;
        for (String card: cards) {
            int points;
            if (card.startsWith("10")){
                char type = card.charAt(2);
                points = 10 * symbolVal.get(type);
            }
            else {
                char power  = card.charAt(0);
                char type  = card.charAt(1);
                points = symbolVal.get(power) * symbolVal.get(type);
            }

            sumPoints+= points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues(){
        Map<Character, Integer> charVal = new HashMap<>();
        charVal.put('2' , 2);
        charVal.put('3' , 3);
        charVal.put('4' , 4);
        charVal.put('5' , 5);
        charVal.put('6' , 6);
        charVal.put('7' , 7);
        charVal.put('8' , 8);
        charVal.put('9' , 9);
        charVal.put('J' , 11);
        charVal.put('Q' , 12);
        charVal.put('K' , 13);
        charVal.put('A' , 14);
        charVal.put('S' , 4);
        charVal.put('H' , 3);
        charVal.put('D' , 2);
        charVal.put('C' , 1);
        return charVal;
    }
}
