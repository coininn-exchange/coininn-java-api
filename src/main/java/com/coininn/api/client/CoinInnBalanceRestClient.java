package com.coininn.api.client;

import com.coininn.api.bean.balance.AssetBalance;

import java.util.List;

/**
 * @author Aries
 */
public interface CoinInnBalanceRestClient {
    List<AssetBalance> balances();
}
