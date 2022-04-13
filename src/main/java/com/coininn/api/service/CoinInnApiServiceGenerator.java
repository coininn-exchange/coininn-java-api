package com.coininn.api.service;

import com.coininn.api.config.CoinInnApiConfig;
import com.coininn.api.exception.CoinInnApiError;
import com.coininn.api.exception.CoinInnApiException;
import com.coininn.api.security.AuthenticationInterceptor;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * @author Aries
 */
public class CoinInnApiServiceGenerator {

    private static final OkHttpClient okClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        okClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    private static final Converter<ResponseBody, CoinInnApiError> errorBodyConverter =
            (Converter<ResponseBody, CoinInnApiError>) converterFactory.responseBodyConverter(
                    CoinInnApiError.class, new Annotation[0], null);

    /**
     * Create a CoinInn API service.
     *
     * @param serviceClass the type of service.
     * @param apiKey       CoinInn API key.
     * @param secret       CoinInn secret.
     * @return a new implementation of the API endpoints for the CoinInn API service.
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(CoinInnApiConfig.getApiTestUrl())
                .addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(okClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = okClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                CoinInnApiError apiError = getCoinInnApiError(response);
                throw new CoinInnApiException(apiError);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CoinInnApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static CoinInnApiError getCoinInnApiError(Response<?> response) throws IOException, CoinInnApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getOkClient() {
        return okClient;
    }
}
