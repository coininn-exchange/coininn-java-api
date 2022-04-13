package com.coininn.api.client;

import com.coininn.api.service.CoinInnWebSocketClientImpl;
import com.coininn.api.service.balance.CoinInnBalanceRestClientImpl;
import com.coininn.api.service.exchange.CoinInnExchangeApiRestClientImpl;

import static com.coininn.api.service.CoinInnApiServiceGenerator.getOkClient;

/**
 * @author Aries
 */
public class CoinInnApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private CoinInnApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    public static CoinInnApiClientFactory newInstance() {
        return new CoinInnApiClientFactory(null, null);
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the binance api client factory
     */
    public static CoinInnApiClientFactory newInstance(String apiKey, String secret) {
        return new CoinInnApiClientFactory(apiKey, secret);
    }

    public CoinInnExchangeApiRestClient newExchageRestClient() {
        return new CoinInnExchangeApiRestClientImpl(apiKey, secret);
    }

    public CoinInnBalanceRestClient newBalanceRestClient() {
        return new CoinInnBalanceRestClientImpl(apiKey, secret);
    }

    public CoinInnWebSocketClient newWebSocketClient(){
        return new CoinInnWebSocketClientImpl(getOkClient());
    }


}
