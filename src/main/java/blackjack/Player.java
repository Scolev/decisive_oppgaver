package blackjack;

public class Player {

    private Hand hand;

    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    public void printCards() {
        for (Card card : hand.getCards()) {
            System.out.println(card.toString());
        }
        System.out.println("Hand value: " + hand.getHandValue());
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
