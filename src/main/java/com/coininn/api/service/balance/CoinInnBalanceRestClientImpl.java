package com.coininn.api.service.balance;

import com.coininn.api.bean.balance.AssetBalance;
import com.coininn.api.client.CoinInnBalanceRestClient;
import com.coininn.api.service.CoinInnApiService;

import java.util.List;

import static com.coininn.api.service.CoinInnApiServiceGenerator.createService;
import static com.coininn.api.service.CoinInnApiServiceGenerator.executeSync;

/**
 * @author Aries
 */
public class CoinInnBalanceRestClientImpl implements CoinInnBalanceRestClient {

    private final CoinInnApiService coinInnApiService;

    public CoinInnBalanceRestClientImpl(String apiKey, String secret) {
        coinInnApiService = createService(CoinInnApiService.class, apiKey, secret);
    }

    @Override
    public List<AssetBalance> balances() {
        return executeSync(coinInnApiService.balances());
    }
}
