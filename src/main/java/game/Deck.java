package game;

import org.springframework.context.annotation.Configuration;

import java.util.*;
@Configuration
public class Deck {
    private final LinkedList<Card> cards = new LinkedList<>();

    Deck() {
        for(Suit suits: Suit.values()){
            for(int j = 1; j <= 13; j++){
                Card card = new Card(j,suits);
                cards.add(card);
            }
        }
    }

    public Card drawCard() {
        return cards.removeFirst();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
