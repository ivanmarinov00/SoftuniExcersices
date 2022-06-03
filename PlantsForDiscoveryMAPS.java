package SoftUniExamPrep;

import java.util.*;

public class PlantsForDiscoveryMAPS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Map<String, Double> ratePlants = new HashMap<>();
        Map<String, Integer> rarityPlants = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            String[] input = s.nextLine().split("<->");
            String name = input[0];
            int rarity = Integer.parseInt(input[1]);
            rarityPlants.put(name, rarity);
            ratePlants.put(name, 0.0);


        }
        String i = s.nextLine();
        while (!i.equals("Exhibition")){
            String[] commands = i.split(" "); //Rate: Woodii - 10 -> ["Rate:", "Woodii", "-", "10"]
            String command = commands[0];
            String plantName = commands[1];
            switch (command) {
                case "Rate:": // ["Rate:", "Woodii", "-", "10"]
                    double rating = Integer.parseInt(commands[3]);
                    if (ratePlants.get(plantName) == 0) {
                        ratePlants.put(plantName, rating);
                    } else {
                        double newRate = (ratePlants.get(plantName) + rating) / 2;
                        ratePlants.put(plantName, newRate);
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(commands[3]);
                    rarityPlants.put(plantName, newRarity);
                    break;
                case "Reset:":
                    ratePlants.put(plantName, 0.0);
                    break;
                default:
                    System.out.println("error");
            }
            i = s.nextLine();
        }
        System.out.println("Plants for the exhibition");
        rarityPlants.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue() - e1.getValue();
                    if (result == 0) {
                        double res = (ratePlants.get(e2.getKey()) - ratePlants.get(e1.getKey()));
                        return (int) res;
                    }
                    return result;
        })
                .forEach(e -> {
                    System.out.printf("- %s: Rarity: 5; Rating: 7.50", e.getKey(),e.getValue(), ratePlants.get(e.getKey()));
                });
    }
}
