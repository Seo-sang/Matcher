package com.project.frontend.web;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final RetrofitClient instance = new RetrofitClient();
    private static RetrofitService retrofitService;

    private static final String baseUrl = "https://1e87-59-15-25-132.ngrok.io";

    public static String getBaseUrl() {
        return baseUrl;
    }

    private RetrofitClient() {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    public static RetrofitClient getInstance() {
        return instance;
    }

    public static RetrofitService getRetrofitService() {
        return retrofitService;
    }

    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String s) {
                android.util.Log.e("Retrofit", s);
            }
        });

        return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
