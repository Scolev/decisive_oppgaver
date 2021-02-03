package com.company;

public class Card {
    private final int number;
    private final Suit suit;

    Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return this.number;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (number <= 10 && number > 1) {
            sb.append(number);
        } else if (number == 1) {
            sb.append("Ace");
        } else if (number == 11) {
            sb.append("Jack");
        } else if (number == 12) {
            sb.append("Queen");
        } else if (number == 13) {
            sb.append("King");
        }
        sb.append(" of ").append(suit);

        return sb.toString();
    }
}
