package com.coininn.api.bean.exchange;

/**
 * @author Aries
 */
public enum OrderStatus {
    NEW((byte) 2),
    FILLED((byte) 3),
    CANCELED((byte) 4);

    private byte state;

    OrderStatus(byte state) {
        this.state = state;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}
