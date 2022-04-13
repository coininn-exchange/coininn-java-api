package com.coininn.api.client;

import com.coininn.api.bean.market.OrderBook;

import java.io.Closeable;

/**
 * @author Aries
 */
public interface CoinInnWebSocketClient {

    Closeable onDepthEvent(String symbols, CoinInnApiCallback<OrderBook> callback);
}
