package com.coininn.api.bean;

/**
 * @author Aries
 */
public enum OrderType {
    MARKET_BUY(1, "MARKET"),
    MARKET_SELL(2, "MARKET"),
    LIMIT_BUY(9, "LIMIT"),
    LIMIT_SELL(11, "LIMIT");

    private Integer type;
    private String value;

    OrderType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
