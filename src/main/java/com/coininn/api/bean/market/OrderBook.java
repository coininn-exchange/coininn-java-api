package com.coininn.api.bean.market;

import com.coininn.api.constants.CoinInnApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Aries
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook<T> {

    @JsonProperty("t")
    private String type;

    private long time;

    @JsonProperty("d")
    private T data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoinInnApiConstants.TO_STRING_BUILDER_STYLE)
                .append("type", type)
                .append("time", time)
                .append("data", data)
                .toString();
    }
}
