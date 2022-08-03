package game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Player {
    private final Hand hand = new Hand();

    public void drawCard(Deck deck){
        hand.addCard(deck.drawCard());
    }

    public void printCards(){
        for(Card card: hand.getCards()){
            System.out.println(card.toString());
        }
        System.out.println("Hand value: " + hand.getHandValue());
    }

    public String getCardsAsString(){
        StringBuilder sb = new StringBuilder();
        for(Card card: hand.getCards()){
            sb.append(card.toString());
        }
        sb.append("Hand value: " + hand.getHandValue());
        return sb.toString();
    }

    public Hand getHand() {
        return hand;
    }
}
