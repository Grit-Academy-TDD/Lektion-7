package org.example.services;

public class CurrencyConverter {
    private static double SEK_TO_EUR = 0.10;

    public static int toEuro(int price) {
        return (int) (price * SEK_TO_EUR);
    }
}
