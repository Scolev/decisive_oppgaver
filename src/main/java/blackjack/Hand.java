package blackjack;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    private Boolean showAllCards = true;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void emptyHand() {
        this.cards.clear();
    }

    public ArrayList<Card> getCards() {
        if (showAllCards) {
            return cards;
        } else {
            return new ArrayList<Card>() {{
                add(cards.get(0));
            }};
        }
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        if (showAllCards) {
            int val = 0;
            int aces = 0;

            for (Card card : cards) {
                if (card.getNumber() > 10) {
                    val += 10;
                } else if (card.getNumber() == 1) {
                    aces++;
                } else {
                    val += card.getNumber();
                }
            }
            for (int i = 0; i < aces; i++) {
                if (val + 10 > 21 - aces) {
                    val += 1;
                } else {
                    val += 11;
                }
            }
            return val;
        } else {
            if (cards.get(0).getNumber() > 10) {
                return 10;
            } else if (cards.get(0).getNumber() == 1) {
                return 11;
            } else {
                return cards.get(0).getNumber();
            }
        }
    }

    @JsonIgnore
    public Boolean getShowAllCards() {
        return showAllCards;
    }

    @JsonIgnore
    public void setShowAllCards(Boolean showAllCards) {
        this.showAllCards = showAllCards;
    }
}
