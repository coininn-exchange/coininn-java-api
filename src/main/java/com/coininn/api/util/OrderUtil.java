package com.coininn.api.util;

import com.coininn.api.bean.OrderType;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aries
 */
public class OrderUtil {

    private static Set<Integer> marketTypes = new HashSet<>();
    private static Set<Integer> limitTypes = new HashSet<>();

    static {
        marketTypes.add(OrderType.MARKET_BUY.getType());
        marketTypes.add(OrderType.MARKET_SELL.getType());
        limitTypes.add(OrderType.LIMIT_BUY.getType());
        limitTypes.add(OrderType.LIMIT_SELL.getType());
    }

    public static boolean isMarketTypes(Integer type) {
        return marketTypes.contains(type);
    }

    public static boolean isLimitTypes(Integer type) {
        return limitTypes.contains(type);
    }
}
