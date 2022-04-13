package com.coininn.api.constants;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Aries
 */
public class CoinInnApiConstants {

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "X-API-KEY";

    /**
     * HTTP Header to be used for API-SECRET authentication.
     */
    public static final String API_SECRET_HEADER = "X-API-SECRET";

    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     * - Example ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;


}
