package com.company;

public class Player {
    Hand hand = new Hand();

    public void drawCard(Deck deck){
        hand.addCard(deck.getCards().get(0));
        deck.getCards().remove(0);
    }

    public void printCards(){
        for(Card card: hand.getCards()){
            System.out.println(card.toString());
        }
        System.out.println("Hand value: " + hand.getHandValue());
    }
}
