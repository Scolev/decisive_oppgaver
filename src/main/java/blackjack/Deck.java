package blackjack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.LinkedList;

@Configuration
public class Deck {

    private LinkedList<Card> cards = new LinkedList<>();

    public Deck() {
        for (Suit suits : Suit.values()) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j, suits);
                cards.add(card);
            }
        }
    }

    @JsonIgnore
    public LinkedList<Card> getCards() {
        return cards;
    }

    @JsonIgnore
    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }

    public Card drawCard() {
        return cards.removeFirst();
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
