package com.company;

import java.util.*;

public class Deck {

    //Bruker LinkedList for å støtte både shuffle og removeFirst
    //Gjort private og final - collection av Cards er en implementasjonsdetalj som skal gjemmes fra de andre klassene
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
