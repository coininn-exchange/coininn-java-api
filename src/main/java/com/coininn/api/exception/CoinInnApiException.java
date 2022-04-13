package com.coininn.api.exception;

/**
 * @author Aries
 */
public class CoinInnApiException extends RuntimeException {

    /**
     * Error response object returned by coininn API.
     */
    private CoinInnApiError error;

    /**
     * Instantiates a new coininn api exception.
     *
     * @param error an error response object
     */
    public CoinInnApiException(CoinInnApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new coininn api exception.
     *
     * @param cause the cause
     */
    public CoinInnApiException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "code: " + error.getCode() + " msg: " + error.getMessage();
    }
}
