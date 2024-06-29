package org.example;

import java.util.List;

public class Main {
    public static int calculateFavoriteIceCream(List<String> votes) {
        if (votes == null) {
            throw new IllegalArgumentException("Votes cannot be null");
        }

        if (votes.size() == 0) {
            throw new IllegalArgumentException("No votes provided");
        }

        int[] intVotes = new int[votes.size()];
        int i = 0;

        for (String vote : votes) {
            try {
                if (vote.length() > 1) {
                    throw new IllegalArgumentException("Invalid vote provided: " + vote);
                }
                int intVote = Integer.parseInt(vote);
                if (intVote < 0 || intVote > 4) {
                    throw new IllegalArgumentException("Invalid vote provided: " + vote);
                }
                intVotes[i++] = Integer.parseInt(vote);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid vote provided: " + vote);
            }
        }

        int[] votesByIceCreamType = new int[5];
        int favoriteIceCream = 0;

        for (int vote : intVotes) {
            votesByIceCreamType[vote]++;
        }

        for (int j = 1; j < votesByIceCreamType.length; j++) {
            if (votesByIceCreamType[j] > votesByIceCreamType[favoriteIceCream] ||
                    (votesByIceCreamType[j] == votesByIceCreamType[favoriteIceCream] && j < favoriteIceCream)) {
                favoriteIceCream = j;
            }
        }

        return favoriteIceCream;
    }

    public static void main(String[] args) {
        // Exemplos de uso
        List<String> votes1 = List.of("0", "2", "3", "4", "4");
        List<String> votes2 = List.of("1", "1", "1", "3", "4", "4");
        List<String> votes3 = List.of("1", "1", "3", "0", "1", "4", "0", "0");

        System.out.println(calculateFavoriteIceCream(votes1));
        System.out.println(calculateFavoriteIceCream(votes2));
        System.out.println(calculateFavoriteIceCream(votes3));
    }
}