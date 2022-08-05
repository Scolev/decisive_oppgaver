package blackjack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;


public class Game {


    public Player player;

    public Player dealer;
    @JsonIgnore
    public Deck deck;

    public Result result = null;

    @Autowired
    public Game() {
        this.deck = new Deck();
        this.player = new Player("Player");
        this.dealer = new Player("Dealer");
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
