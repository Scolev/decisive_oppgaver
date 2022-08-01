import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

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
