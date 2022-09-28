package Unit;

import blackjack.Game;
import blackjack.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTests {

    Player player;
    Player dealer;
    Game game;

    @BeforeEach
    public void init() {
        player = new Player("player");
        dealer = new Player("dealer");
        game = new Game(player, dealer);
    }

    @Test
    public void gameInitialization_Test() {
        Assertions.assertNotNull(game);
        Assertions.assertNotNull(game.getDeck());
        Assertions.assertNotNull(game.getPlayer());
        Assertions.assertNotNull(game.getPlayer().getHand());
        Assertions.assertNotNull(game.getDealer());
        Assertions.assertNotNull(game.getDealer().getHand());
    }

    @Test
    public void drawCard_Test() {
        player.drawCard(game.getDeck());

        Assertions.assertEquals(1, player.getHand().getCards().size());
        Assertions.assertEquals(51, game.getDeck().getCards().size());
    }
}
