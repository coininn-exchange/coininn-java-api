package com.coininn.api.service;

import com.coininn.api.bean.market.OrderBook;
import com.coininn.api.client.CoinInnApiCallback;
import com.coininn.api.client.CoinInnWebSocketClient;
import com.coininn.api.config.CoinInnApiConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Aries
 * @version 2.0.0
 * @ClassName CoinInnWebSocketClientImpl.java
 * @Copyright: JobWen Technologies Co., Ltd. Copyright 2017-2021,  All rights reserved
 * @Description TODO
 * @createTime 2022年04月12日 16:58:00
 */
public class CoinInnWebSocketClientImpl implements CoinInnWebSocketClient, Closeable {

    private final OkHttpClient client;

    public CoinInnWebSocketClientImpl(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public Closeable onDepthEvent(String symbols, CoinInnApiCallback<OrderBook> callback) {
        return createNewWebSocket(symbols, new CoinInnWebSocketListener<>(callback, OrderBook.class));
    }

    @Override
    public void close() throws IOException {

    }

    private Closeable createNewWebSocket(String symbol, CoinInnWebSocketListener<?> listener) {
        Request request = new Request.Builder().url(CoinInnApiConfig.getStreamApiBaseUrl()).addHeader("symbol", symbol).build();
        WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }


}
