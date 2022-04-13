package com.coininn.api;

import com.coininn.api.bean.OrderFiat;
import com.coininn.api.bean.OrderSide;
import com.coininn.api.bean.OrderType;
import com.coininn.api.bean.balance.AssetBalance;
import com.coininn.api.bean.exchange.NewOrder;
import com.coininn.api.bean.exchange.OrderResponse;
import com.coininn.api.client.CoinInnApiClientFactory;
import com.coininn.api.client.CoinInnBalanceRestClient;
import com.coininn.api.client.CoinInnExchangeApiRestClient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aries
 */
public class CoinInnApiResultClient {

    CoinInnExchangeApiRestClient coinInnExchangeApiRestClient = null;
    CoinInnBalanceRestClient coinInnBalanceRestClient = null;

    @Before
    public void before() {
        CoinInnApiClientFactory factory = CoinInnApiClientFactory.newInstance("API-KEY", "API-SECRET");
        coinInnExchangeApiRestClient = factory.newExchageRestClient();
        coinInnBalanceRestClient = factory.newBalanceRestClient();
    }

    /**
     * ***********************************************************************
     * Exchange TEST
     * ***********************************************************************
     */
    @Test
    public void createOrder() {
        NewOrder order = new NewOrder();
        order.setSymbol("BTC");
        order.setBaseCurrency(OrderFiat.USDT);
        order.setSide(OrderSide.BUY.getType());

        /*order.setType(OrderType.MARKETBUY.getType());
        order.setFiatAmount(new BigDecimal("1")); // Buy Or Sell 1 USDT
        //order.setAmount(new BigDecimal("0.00005")); // Buy Or Sell 0.00005 amount*/

        order.setType(OrderType.LIMIT_BUY.getType());
        order.setPrice(new BigDecimal("38000"));
        order.setAmount(new BigDecimal("0.00005"));
        OrderResponse newOrderResponse = coinInnExchangeApiRestClient.newOrder(order);
        System.out.println(newOrderResponse.toString());
    }

    @Test
    public void cancelOrder() {
        OrderResponse orderResponse = coinInnExchangeApiRestClient.cancelOrder(1233388);
        System.out.println(orderResponse.toString());
    }

    @Test
    public void orderStatus() {
        OrderResponse orderResponse = coinInnExchangeApiRestClient.orderOrderStatus(1233388);
        System.out.println(orderResponse.toString());
    }


    /**
     * ***********************************************************************
     * BALANCE TEST
     * ***********************************************************************
     */
    @Test
    public void balances() {
        List<AssetBalance> balances = coinInnBalanceRestClient.balances();
        System.out.println(balances.toString());
    }

    /**
     * ***********************************************************************
     * KLINE TEST
     * ***********************************************************************
     */

}
