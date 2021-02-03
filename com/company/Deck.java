package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<>();

    Deck() {
        for(Suit suits: Suit.values()){
            for(int j = 1; j <= 13; j++){
                Card card = new Card(j,suits);
                cards.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}
