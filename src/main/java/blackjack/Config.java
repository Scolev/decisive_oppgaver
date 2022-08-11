package blackjack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("main.java.blackjack")

public class Config {

    @Bean
    public Player player() {
        return new Player("Player");
    }

    @Bean
    public Player dealer() {
        return new Player("Dealer");
    }
}
