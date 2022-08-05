package blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Player {
    @Autowired
    private Hand hand;

    private String name;

    public Player(){

    }

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

    public String getCardsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand.getCards()) {
            sb.append(card.toString());
            sb.append('\n');
        }
        sb.append("Hand value: " + hand.getHandValue());
        sb.append('\n');
        return sb.toString();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
