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

    public Hand getHand() {
        return hand;
    }
}
