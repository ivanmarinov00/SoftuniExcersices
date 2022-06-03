package JavaAdvanced;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MeetingDEQUE {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> femaleNumbers = new ArrayDeque<>();

        String[] maleInput = scanner.nextLine().split("\\s+");
        for (String number : maleInput) {
            maleNumbers.push(Integer.parseInt(number));
        }

        String[] femaleInput = scanner.nextLine().split("\\s+");
        for (String number : femaleInput) {
            femaleNumbers.offer(Integer.parseInt(number));
        }

        int matchesCounter = 0;
        while (!femaleNumbers.isEmpty() && !maleNumbers.isEmpty()) {
            boolean continueNext = false;
            int currentMaleNumber = maleNumbers.peek();
            int currentFemaleNumber = femaleNumbers.peek();
            if (currentMaleNumber % 25 == 0 || currentMaleNumber<=0) {
                maleNumbers.pop();
                continueNext = true;
            }
            if (currentFemaleNumber % 25 == 0 || currentFemaleNumber<=0) {
                femaleNumbers.poll();
                continueNext = true;
            }

            if (continueNext) {
                continue;
            }
            if (currentFemaleNumber == currentMaleNumber) {
                maleNumbers.pop();
                femaleNumbers.poll();
                matchesCounter++;
            } else {
                femaleNumbers.poll();
                if (!maleNumbers.isEmpty()) {
                    int maleNumber = maleNumbers.pop();
                    maleNumber -= 2;
                    maleNumbers.push(maleNumber);
                }
            }
        }


        System.out.println("Matches: " + matchesCounter);
        if (maleNumbers.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            String output = maleNumbers
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(output);
        }

        if (femaleNumbers.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String output = femaleNumbers
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(output);
        }
    }
}
