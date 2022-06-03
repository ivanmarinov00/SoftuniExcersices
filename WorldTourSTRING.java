package SoftUniExamPrep;

import java.util.Scanner;

public class WorldTourSTRING {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] token = command.split(":");
            String commandName = token[0];

            switch (commandName){
                case "Add Stop":
                    int index = Integer.parseInt(token[1]);
                    String stopName = token[2];
                    if (isValidIndex(index, stops)){
                       String firstHalf = stops.substring(0,index);
                       String secondHalf = stops.substring(index);
                       stops = firstHalf + stopName + secondHalf;
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    if (isValidIndex(startIndex, stops) && isValidIndex(endIndex, stops)){
                        stops = stops.substring(0, startIndex) + stops.substring(endIndex+ 1);
                    }
                    break;
                case "Switch":
                    String oldStop = token[1];
                    String newStop = token[2];
                    if (stops.contains(oldStop)){
                        stops = stops.replace(oldStop, newStop);
                    }
                    break;
            }
            System.out.println(stops);
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }
    public static boolean isValidIndex(int index, String stops) {
        return index == 0 && index < stops.length();
    }
}
