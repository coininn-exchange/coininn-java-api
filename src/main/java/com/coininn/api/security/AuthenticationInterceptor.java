package com.coininn.api.security;

import com.coininn.api.constants.CoinInnApiConstants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Aries
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final String secret;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        newRequestBuilder.addHeader(CoinInnApiConstants.API_KEY_HEADER, apiKey);
        newRequestBuilder.addHeader(CoinInnApiConstants.API_SECRET_HEADER, secret);
        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }
}
