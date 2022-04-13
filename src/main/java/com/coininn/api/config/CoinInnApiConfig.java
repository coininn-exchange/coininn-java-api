package com.coininn.api.config;

/**
 * Configuration used for CoinInn operations.
 */
public class CoinInnApiConfig {

    /**
     * Base domain for URLs.
     */
    private static String BASE_DOMAIN = "coininn.com";
    private static String TEST_DOMAIN = "192.168.0.105:9000";

    /**
     * Set the URL base domain name (e.g., coininn.com).
     *
     * @param baseDomain Base domain name
     */
    public static void setBaseDomain(final String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }

    /**
     * Get the URL base domain name (e.g., coininn.com).
     *
     * @return The base domain for URLs
     */
    public static String getBaseDomain() {
        return BASE_DOMAIN;
    }

    public static String getTestDomain() {
        return TEST_DOMAIN;
    }

    /**
     * REST API base URL.
     */
    public static String getApiBaseUrl() {
        return String.format("https://www.%s", getBaseDomain());
    }

    public static String getApiTestUrl() {
        return String.format("http://%s", getTestDomain());
    }

    /**
     * Streaming API base URL.
     */
    public static String getStreamApiBaseUrl() {
        return String.format("wss://www.%s/ws", getBaseDomain());
    }
}
