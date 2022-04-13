package com.coininn.api.exception;

import com.coininn.api.constants.CoinInnApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Aries
 * CoinInn API error object.
 */
public class CoinInnApiError {
    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoinInnApiConstants.TO_STRING_BUILDER_STYLE)
                .append("code", code)
                .append("msg", message)
                .toString();
    }

}
