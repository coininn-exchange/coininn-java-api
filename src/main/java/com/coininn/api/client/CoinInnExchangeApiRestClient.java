package com.coininn.api.client;

import com.coininn.api.bean.exchange.NewOrder;
import com.coininn.api.bean.exchange.OrderResponse;

/**
 * CoinInn API facade, supporting synchronous/blocking access CoinInn's REST API.
 */
public interface CoinInnExchangeApiRestClient {

    /**
     * Send in a new order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    OrderResponse newOrder(NewOrder order);

    OrderResponse cancelOrder(Integer orderId);

    OrderResponse orderOrderStatus(Integer orderId);

}
