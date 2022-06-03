package SoftUniExamPrep;

import java.util.*;

public class LegendaryFarmingWoWMAPS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        boolean acquired = false;

        while (!acquired) {

            String input = s.nextLine();
            String[] mats = input.split(" ");

            for (int i = 0; i < input.length(); i += 2) {
                int quantity = Integer.parseInt(mats[i]);
                String type = mats[i + 1].toLowerCase();

                if (type.equals("shards") || type.equals("fragments") || type.equals("motes")) {
                    materials.put(type, materials.get(type) + quantity);
                    if (materials.get(type) >= 250) {
                        if (type.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        }
                        else if (type.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }
                        else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        materials.put(type, materials.get(type) - 250);
                        acquired = true;
                        break;
                    }
                }
                else {
                        if (!junk.containsKey(type)){
                            junk.put(type, quantity);
                        }
                        else {
                            junk.put(type, junk.get(type) + quantity);
                        }
                    }
            }
        }
        materials.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
