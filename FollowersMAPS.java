package SoftUniExamPrep;

import java.util.*;

public class FollowersMAPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> likesMap = new TreeMap<>();

        String input = sc.nextLine();

        while(!input.equals("Log out")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];

            switch(command) {
                case "New follower":
                    String userName = tokens[1];

                    likesMap.putIfAbsent(userName, 0);
                    break;
                case "Like":
                    userName = tokens[1];
                    int newLikes = Integer.parseInt(tokens[2]);

                    if(likesMap.containsKey(userName)) {
                        int oldLikes = likesMap.get(userName);
                        likesMap.put(userName, oldLikes + newLikes);
                    } else {
                        likesMap.put(userName, newLikes);
                    }
                    break;
                case "Comment":
                    userName = tokens[1];
                    if(likesMap.containsKey(userName)) {
                        int oldComments = likesMap.get(userName);
                        likesMap.put(userName, ++oldComments);
                    } else {
                        likesMap.put(userName, 1);
                    }
                    break;
                case "Blocked":
                    userName = tokens[1];
                    if(!likesMap.containsKey(userName)) {
                        System.out.printf("%s doesn't exist.\n", userName);
                    } else {
                        likesMap.remove(userName);
                    }
                    break;
            }

            input = sc.nextLine();
        }

        System.out.printf("%d followers\n", likesMap.size());
        likesMap.entrySet().stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue() - p1.getValue();
                    return result;
                }).forEach(entry -> {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
        });
    }

}


