package com.coininn.api.client;

/**
 * @author Aries
 */
public interface CoinInnApiCallback<T> {
    /**
     * Called whenever a response comes back from the CoinInn API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {}
}
