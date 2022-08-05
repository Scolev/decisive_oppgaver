package presentation;


import blackjack.Game;
import blackjack.Result;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan(basePackages = "blackjack")
@RestController
public class BlackjackController {

    public Game game;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/newGame")
    String startNewGame(@RequestParam(required = false) String name) throws JsonProcessingException {
        game = new Game();
        if (name != null) {
            game.player.setName(name);
        }
        game.deck.shuffleDeck();
        game.dealer.drawCard(game.deck);
        game.dealer.drawCard(game.deck);
        game.player.drawCard(game.deck);
        game.player.drawCard(game.deck);
        if (game.player.getHand().getHandValue() == 21) {
            game.setResult(Result.PLAYER_WINS);
            //TODO: Win msg
            return objectMapper.writeValueAsString(game);
        }
        //TODO: show hand + dealer first card
        return objectMapper.writeValueAsString(game);
    }

    @GetMapping("/hit")
    String hit() throws JsonProcessingException {
        if (game.getResult() == null) {
            game.player.drawCard(game.deck);
            if (game.player.getHand().getHandValue() > 21) {
                game.setResult(Result.DEALER_WINS);
            }
            return objectMapper.writeValueAsString(game.player.getHand());
        } else {
            return "You've already lost! Start a '/newGame' to play again.";
        }
    }

    @GetMapping("/stay")
    String stay() throws JsonProcessingException {
        if(game.getResult() == null) {
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

    @GetMapping("/test")
    String testfunction() throws JsonProcessingException {
        String insideFunc = "Test";
        game = new Game();
        game.deck.shuffleDeck();
        game.dealer.drawCard(game.deck);
        game.dealer.drawCard(game.deck);
        game.player.drawCard(game.deck);
        game.player.drawCard(game.deck);
        return objectMapper.writeValueAsString(game);
    }

}
