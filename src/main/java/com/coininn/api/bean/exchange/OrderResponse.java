package com.coininn.api.bean.exchange;

import com.coininn.api.constants.CoinInnApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * Response returned when placing a new order on the system.
 *
 * @see NewOrder for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {
    /**
     * order Id
     */
    private Integer orderId;
    /**
     * Order symbol
     */
    private String symbol;
    /**
     * Fiat Currency
     */
    private String baseCurrency;

    private BigDecimal amount;

    private BigDecimal fiatAmount;
    /**
     * Order Executed Amount
     */
    private BigDecimal executedAmount;

    /**
     * Order Executed Fiat Amount
     */
    private BigDecimal executedFiatAmount;

    /**
     * @see com.coininn.api.bean.OrderType
     */
    private Integer orderType;

    /**
     * @see OrderStatus
     */
    private byte orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
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

    public BigDecimal getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(BigDecimal executedAmount) {
        this.executedAmount = executedAmount;
    }

    public BigDecimal getExecutedFiatAmount() {
        return executedFiatAmount;
    }

    public void setExecutedFiatAmount(BigDecimal executedFiatAmount) {
        this.executedFiatAmount = executedFiatAmount;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public byte getOrderState() {
        return orderState;
    }

    public void setOrderState(byte orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoinInnApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("orderType", orderType)
                .append("orderState", orderState)
                .append("symbol", symbol)
                .append("baseCurrency", baseCurrency)
                .append("amount", amount)
                .append("fiatAmount", fiatAmount)
                .append("executedAmount", executedAmount)
                .append("executedFiatAmount", executedFiatAmount)
                .toString();
    }


}
