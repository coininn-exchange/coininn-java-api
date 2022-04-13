package com.coininn.api.bean.balance;

import com.coininn.api.constants.CoinInnApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author Aries
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetBalance {

    /**
     * Asset symbol.
     */
    private String symbol;

    /**
     * Available balance.
     */
    private BigDecimal amount;

    /**
     * Locked by open orders.
     */
    private BigDecimal frozenAmount;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoinInnApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("amount", amount)
                .append("frozenAmount", frozenAmount)
                .toString();
    }
}
