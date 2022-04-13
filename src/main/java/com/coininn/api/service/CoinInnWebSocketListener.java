package com.coininn.api.service;

import com.coininn.api.client.CoinInnApiCallback;
import com.coininn.api.exception.CoinInnApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * @author Aries
 */
public class CoinInnWebSocketListener<T> extends WebSocketListener {

    private CoinInnApiCallback<T> callback;
    private static final ObjectMapper mapper = new ObjectMapper();

    private final ObjectReader objectReader;

    public CoinInnWebSocketListener(CoinInnApiCallback<T> callback, Class<T> tClass) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(tClass);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send(webSocket.request().header("symbol"));
    }

    @Override
    public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
        System.out.println("Connection failed,Please reconnect!");
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        System.out.println("Connection is about to disconnect！");
    }

    @Override
    public void onClosed(final WebSocket webSocket, final int code, final String reason) {
        System.out.println("Connection dropped！");
    }

    @Override
    public void onMessage(final WebSocket webSocket, final String bytes) {
        try {
            T event = objectReader.readValue(bytes);
            callback.onResponse(event);
        } catch (IOException e) {
            throw new CoinInnApiException(e);
        }
    }


}
