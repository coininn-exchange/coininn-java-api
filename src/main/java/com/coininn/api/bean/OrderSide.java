package com.coininn.api.bean;

/**
 * @author Aries
 * @version 2.0.0
 * @ClassName OrderSide.java
 * @Copyright: JobWen Technologies Co., Ltd. Copyright 2017-2021,  All rights reserved
 * @Description TODO
 * @createTime 2022年04月11日 11:37:00
 */
public enum OrderSide {
    BUY(1, "BUY"),
    SELL(2, "SELL");

    private Integer type;
    private String value;

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

    OrderSide(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

}
