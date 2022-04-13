package com.coininn.api.client;

import com.coininn.api.service.CoinInnWebSocketListener;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.time.Duration;

/**
 * @author Aries
 */
public class WebSocketClient {

    private static Boolean isConnect = false;
    private static WebSocket webSocket = null;

    public static void connection(final String url, CoinInnWebSocketListener<?> listener) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        OkHttpClient client = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .connectTimeout(Duration.ofSeconds(20))
//                .pingInterval(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        webSocket = client.newWebSocket(request, listener);
    }


    public static void sendMessage(String str) {
        if (isConnect) {
            System.out.println(" send " + str);
            webSocket.send(str);
        }
    }
}
