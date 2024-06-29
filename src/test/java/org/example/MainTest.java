package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MainTest {

    @Test
    public void testCalculateFavoriteIceCreamCase1() {
        List<String> votes = List.of("0", "2", "3", "4", "4");
        assertEquals(4, Main.calculateFavoriteIceCream(votes),
                "The most popular flavor should be 4.");
    }

    @Test
    public void testCalculateFavoriteIceCreamCase2() {
        List<String> votes = List.of("1", "1", "1", "3", "4", "4");
        assertEquals(1, Main.calculateFavoriteIceCream(votes),
                "The most popular flavor should be 1.");
    }

    @Test
    public void testCalculateFavoriteIceCreamCase3() {
        List<String> votes = List.of("1", "1", "3", "0", "1", "4", "0", "0");
        assertEquals(0, Main.calculateFavoriteIceCream(votes),
                "The most popular flavor should be 0.");
    }

    @Test
    public void testCalculateFavoriteIceCreamTie() {
        List<String> votes = List.of("2", "2", "3", "3");
        assertEquals(2, Main.calculateFavoriteIceCream(votes),
                "In case of a tie, the smallest code should be returned.");
    }

    @Test
    public void testCalculateFavoriteIceCreamSingleVote() {
        List<String> votes = List.of("1");
        assertEquals(1, Main.calculateFavoriteIceCream(votes),
                "With a single vote, the voted flavor should be returned.");
    }

    @Test
    public void testCalculateFavoriteIceCreamEmpty() {
        List<String> votes = List.of();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("No votes provided", exception.getMessage());
    }

    @Test
    public void testCalculateFavoriteIceCreamInvalidCharacter() {
        List<String> votes = List.of("1", "a", "3");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("Invalid vote provided: a", exception.getMessage());
    }

    @Test
    public void testCalculateFavoriteIceCreamSpecialCharacter() {
        List<String> votes = List.of("1", "@", "3");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("Invalid vote provided: @", exception.getMessage());
    }

    @Test
    public void testCalculateFavoriteIceCreamMultipleCharacters() {
        List<String> votes = List.of("1", "Gabriel", "3");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("Invalid vote provided: Gabriel", exception.getMessage());
    }

    @Test
    public void testCalculateFavoriteIceCreamInvalidVoteValue() {
        List<String> votes = List.of("1", "8", "3");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("Invalid vote provided: 8", exception.getMessage());
    }

    @Test
    public void testCalculateFavoriteIceCreamNullInput() {
        List<String> votes = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateFavoriteIceCream(votes);
        });
        assertEquals("Votes cannot be null", exception.getMessage());
    }
}