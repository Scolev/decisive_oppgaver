package Component;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import presentation.BlackjackApplication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BlackjackApplication.class)
public class EndpointTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void startGameWithEndpointTest() throws JSONException {
        String get = this.testRestTemplate.getForObject("http://localhost:" + port + "/newGame", String.class);
        JSONObject jo = new JSONObject(get.replace("\\\"", "'"));

        Assertions.assertNotNull(jo.get("dealer"));
        Assertions.assertEquals(1, jo.getJSONObject("dealer").getJSONObject("hand").getJSONArray("cards").length());
        Assertions.assertNotNull(jo.get("player"));
        Assertions.assertEquals(2, jo.getJSONObject("player").getJSONObject("hand").getJSONArray("cards").length());
    }
}
