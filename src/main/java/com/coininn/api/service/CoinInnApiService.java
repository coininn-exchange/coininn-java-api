package com.coininn.api.service;

import com.coininn.api.bean.OrderFiat;
import com.coininn.api.bean.balance.AssetBalance;
import com.coininn.api.bean.exchange.OrderResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aries
 */
public interface CoinInnApiService {
    @POST("/api/spot/market")
    Call<OrderResponse> newOrder(@Query("symbol") String symbol, @Query("baseCurrency") OrderFiat baseCurrency, @Query("tradeType") Integer tradeType,
                                 @Query("amount") BigDecimal amount, @Query("fiatAmount") BigDecimal fiatAmount);

    @POST("/api/spot/limit")
    Call<OrderResponse> newOrderQtv(@Query("symbol") String symbol, @Query("baseCurrency") OrderFiat baseCurrency, @Query("tradeType") Integer tradeType,
                                    @Query("amount") BigDecimal amount, @Query("fiatAmount") BigDecimal fiatAmount, @Query("price") BigDecimal price);

    @POST("/api/spot/cancel")
    Call<OrderResponse> cancelOrder(@Query("orderId") Integer orderId);

    @POST("/api/spot/orderStatus")
    Call<OrderResponse> orderOrderStatus(@Query("orderId") Integer orderId);

    @GET("/api/wallet/balances")
    Call<List<AssetBalance>> balances();
}
