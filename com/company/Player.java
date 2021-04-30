package com.company;

public class Player {
    //Denne er package-private, som er ok siden alt ligger i samme pakke. Samtidig så brukes public over alt ellers, fint å være konsekvent.
    //Siden denne bare er package-private, og ikke private, så kan andre klasser bytte ut hånden.
    //Endret til private, og lagt på get-er
    private final Hand hand = new Hand();

    public void drawCard(Deck deck){
        //Endret slik at Player får minst mulig ansvar her. Deck tar selv ansvar for integriteten på sin state,
        //og logikken rundt å trekke kort. Dette var den viktigste forbedringen som ble gjort.
        hand.addCard(deck.drawCard());
    }

    public void printCards(){
        for(Card card: hand.getCards()){
            System.out.println(card.toString());
        }
        System.out.println("Hand value: " + hand.getHandValue());
    }

    public Hand getHand() {
        return hand;
    }
}
