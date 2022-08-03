package presentation;


import game.Deck;
import game.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "game")
@RestController
public class BlackjackController {

    private final String test = "test";
    @Autowired
    Player player;
    @Autowired
    Player dealer;
    @Autowired
    Deck deck;

    @GetMapping("/test")
    String testfunction() {
        String insideFunc = "Test";
        deck.shuffleDeck();
        dealer.drawCard(deck);
        dealer.drawCard(deck);
        player.drawCard(deck);
        player.drawCard(deck);
        return dealer.getCardsAsString() +
                player.getCardsAsString();
    }

    @GetMapping("/start")
    void startgame() {

    }

}
