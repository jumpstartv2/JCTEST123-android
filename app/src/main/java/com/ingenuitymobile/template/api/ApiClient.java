package com.ingenuitymobile.template.api;

import com.ingenuitymobile.template.listeners.OnDisplayErrorListener;
import com.ingenuitymobile.template.listeners.OnPostAgainListener;
import com.ingenuitymobile.template.listeners.OnRefreshTokenListener;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import rx.Subscriber;

/**
 * Created by memengski on 8/8/17.
 */

public class ApiClient {

    public Service service;

    private String consumerSecret;
    private String baseUrl;

    private OnRefreshTokenListener refreshListener;
    private OnDisplayErrorListener displayErrorListener;


    public ApiClient(String consumerSecret,
                     String baseUrl,
                     OnRefreshTokenListener refreshListener,
                     OnDisplayErrorListener displayErrorListener) {

        this.consumerSecret = consumerSecret;
        this.baseUrl = baseUrl;
        this.refreshListener = refreshListener;
        this.displayErrorListener = displayErrorListener;
    }

    public void setAccessToken(String accessToken) {
        service = createRetrofitService(accessToken);
    }

    private Service createRetrofitService(final String accessToken) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

        return new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setEndpoint(baseUrl)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        if (accessToken != null) {
                            request.addHeader("Authorization", "Bearer " + accessToken);
                            request.addHeader("Accept", "application/json");
                        }
                    }
                })
                .build()
                .create(Service.class);
    }

    private class CustomSubscriber<T> extends Subscriber<T> {
        Subscriber<T> subscriber;
        OnPostAgainListener listener;

        CustomSubscriber(Subscriber<T> subscriber, OnPostAgainListener listener) {
            this.subscriber = subscriber;
            this.listener = listener;
        }

        @Override
        public void onCompleted() {
            subscriber.onCompleted();
        }

        @Override
        public void onError(final Throwable e) {
            displayErrorListener.onDisplayError(e);
            subscriber.onError(e);
        }

        @Override
        public void onNext(T t) {
            subscriber.onNext(t);
        }
    }

}
