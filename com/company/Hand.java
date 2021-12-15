package com.company;

import java.util.ArrayList;

public class Hand {

    //Endret til final
    private final ArrayList<Card> cards = new ArrayList<>();

    //Var ikke nødvendig å ha handvalue som eget felt, det beregnes uansett hver gang det brukes

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    //evaluateHand() ble kun brukt internt i Hand-klassen, burde vært private

    //Slått sammen evaluateHand og getHandValue, siden getHandValue i seg selv ikke gjorde noe annet enn å kalle
    //evaluateHand() (etter at handValue ikke lengre er et felt)
    public int getHandValue() {
        int val = 0;
        int aces = 0;

        for(Card card: cards){
            if( card.getNumber() > 10){
                val += 10;
            } else if ( card.getNumber() == 1){
                aces ++;
            } else {
                val += card.getNumber();
            }
        }
        for (int i = 0; i < aces; i++){
            if (val + 10 > 21 - aces){
                val += 1;
            } else {
                val += 11;
            }
        }
        return val;
    }

}
