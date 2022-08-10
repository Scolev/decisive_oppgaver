package presentation;


import blackjack.Game;
import blackjack.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "blackjack")
@RestController
public class BlackjackController {

    public Game game;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/newGame")
    String startNewGame(@RequestParam(required = false) String name) throws JsonProcessingException {
        game = new Game();
        if (name != null) {
            game.getPlayer().setName(name);
        }
        game.getDeck().shuffleDeck();
        game.getDealer().drawCard(game.getDeck());
        game.getDealer().drawCard(game.getDeck());
        game.getPlayer().drawCard(game.getDeck());
        game.getPlayer().drawCard(game.getDeck());
        game.getDealer().getHand().setShowAllCards(false);
        if (game.getPlayer().getHand().getHandValue() == 21) {
            game.setResult(Result.PLAYER_WINS);
            return objectMapper.writeValueAsString(game.getResult());
        }
        return objectMapper.writeValueAsString(game);
    }

    @GetMapping("/hit")
    String hit() throws JsonProcessingException {
        if (game.getResult() == null) {
            game.getPlayer().drawCard(game.getDeck());
            if (game.getPlayer().getHand().getHandValue() > 21) {
                game.setResult(Result.DEALER_WINS);
            }
            return objectMapper.writeValueAsString(game.getPlayer().getHand());
        } else {
            return objectMapper.writeValueAsString(game.getResult());
        }
    }

    @GetMapping("/stay")
    String stay() throws JsonProcessingException {
        game.getDealer().getHand().setShowAllCards(true);
        if (game.getResult() == null) {
            while (game.getDealer().getHand().getHandValue() < 17) {
                game.getDealer().drawCard(game.getDeck());
                if (game.getDealer().getHand().getHandValue() > 21) {
                    game.setResult(Result.PLAYER_WINS);
                }
            }
            if (game.getDealer().getHand().getHandValue() == game.getPlayer().getHand().getHandValue()) {
                game.setResult(Result.TIE);
            } else if (game.getDealer().getHand().getHandValue() < game.getPlayer().getHand().getHandValue()) {
                game.setResult(Result.PLAYER_WINS);
            } else {
                game.setResult(Result.DEALER_WINS);
            }
        }
        return objectMapper.writeValueAsString(game.getResult());
    }

    @GetMapping("/gameState")
    String viewGameState() throws JsonProcessingException {
        return objectMapper.writeValueAsString(game);
    }

    @GetMapping("/result")
    String result() throws JsonProcessingException {
        return objectMapper.writeValueAsString(game.getResult());
    }
}
