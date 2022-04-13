package com.coininn.api.bean.exchange;

import com.coininn.api.bean.OrderFiat;
import com.coininn.api.constants.CoinInnApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class NewOrder {
    /**
     * Symbol to place the order on.
     */
    private String symbol;

    /**
     * Fiat currency
     */
    private OrderFiat baseCurrency;

    /**
     * Buy/Sell order side.
     */
    private Integer side;

    /**
     * Type of order.
     */
    private Integer type;

    /**
     * Quantity.
     */
    private BigDecimal amount;

    /**
     * Fiat Quantity.
     */
    private BigDecimal fiatAmount;

    /**
     * Price.
     */
    private BigDecimal price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OrderFiat getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(OrderFiat baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFiatAmount() {
        return fiatAmount;
    }

    public void setFiatAmount(BigDecimal fiatAmount) {
        this.fiatAmount = fiatAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoinInnApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("baseCurrency", baseCurrency)
                .append("side", side)
                .append("type", type)
                .append("amount", amount)
                .append("price", price)
                .append("fiatAmount", fiatAmount)
                .toString();
    }
}
