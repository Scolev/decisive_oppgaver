package blackjack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private Player player;

    private Player dealer;
    @JsonIgnore
    private Deck deck;

    private Result result = null;

    @Autowired
    public Game(Player player, Player dealer) {
        this.deck = new Deck();
        this.player = player;
        this.dealer = dealer;
    }

    public void reshuffle() {
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.result = null;
        this.player.getHand().emptyHand();
        this.dealer.getHand().emptyHand();
        this.dealer.getHand().setShowAllCards(false);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    @JsonIgnore
    public Deck getDeck() {
        return deck;
    }

    @JsonIgnore
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
