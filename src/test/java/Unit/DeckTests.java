package Unit;

import blackjack.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DeckTests {

    @Test
    public void generateFullDeck_Test() {
        Deck deck = new Deck();

        Assertions.assertEquals(52, deck.getCards().size());
    }
}
