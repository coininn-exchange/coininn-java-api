package com.coininn.api;

import com.coininn.api.client.CoinInnApiClientFactory;
import com.coininn.api.client.CoinInnWebSocketClient;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aries
 */
public class CoinInnWsApiResultClient {

    CoinInnWebSocketClient client = null;

    @Before
    public void before() {
        client = CoinInnApiClientFactory.newInstance().newWebSocketClient();
    }

    @Test
    public void orderBook() {
        String channel = "{\"type\":2,\"open\":1,\"symbols\":[\"BTC\"],\"fiat\":2}";
        client.onDepthEvent(channel, response -> {
            System.out.println(response);
        });
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
