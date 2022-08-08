package blackjack;

public class Card {
    private int number;
    private Suit suit;

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
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
