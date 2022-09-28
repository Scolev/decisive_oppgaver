package Component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import presentation.BlackjackApplication;
import presentation.BlackjackController;

@SpringBootTest(classes = BlackjackApplication.class)
public class WebApplicationTests {

    @Autowired
    BlackjackController blackjackController;

    @Test
    public void applicationLoadsTest() throws Exception {
        Assertions.assertNotNull(blackjackController);
    }
}
