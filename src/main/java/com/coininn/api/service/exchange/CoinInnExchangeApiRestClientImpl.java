package com.coininn.api.service.exchange;

import com.coininn.api.bean.exchange.NewOrder;
import com.coininn.api.bean.exchange.OrderResponse;
import com.coininn.api.client.CoinInnExchangeApiRestClient;
import com.coininn.api.service.CoinInnApiService;
import com.coininn.api.util.OrderUtil;
import retrofit2.Call;

import static com.coininn.api.service.CoinInnApiServiceGenerator.createService;
import static com.coininn.api.service.CoinInnApiServiceGenerator.executeSync;

/**
 * @author Aries
 */
public class CoinInnExchangeApiRestClientImpl implements CoinInnExchangeApiRestClient {

    private final CoinInnApiService coinInnApiService;

    public CoinInnExchangeApiRestClientImpl(String apiKey, String secret) {
        coinInnApiService = createService(CoinInnApiService.class, apiKey, secret);
    }

    @Override
    public OrderResponse newOrder(NewOrder order) {
        final Call<OrderResponse> call;
        if (OrderUtil.isMarketTypes(order.getType())) {
            call = coinInnApiService.newOrder(order.getSymbol(), order.getBaseCurrency(), order.getType(), order.getAmount(), order.getFiatAmount());
        } else {
            call = coinInnApiService.newOrderQtv(order.getSymbol(), order.getBaseCurrency(), order.getType(), order.getAmount(), order.getFiatAmount(), order.getPrice());
        }
        return executeSync(call);
    }

    @Override
    public OrderResponse cancelOrder(Integer orderId) {
        return executeSync(coinInnApiService.cancelOrder(orderId));
    }

    @Override
    public OrderResponse orderOrderStatus(Integer orderId) {
        return executeSync(coinInnApiService.orderOrderStatus(orderId));
    }
}
