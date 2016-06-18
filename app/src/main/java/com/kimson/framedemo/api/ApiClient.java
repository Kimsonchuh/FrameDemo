package com.kimson.framedemo.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.kimson.framedemo.AppConfig;
import com.kimson.library.util.TextUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class ApiClient {
    private static final int CONNECT_TIMEOUT_MILLIS = 3000;
    private static final int READ_TIMEOUT_MILLIS = 3000;
    private static final int WRITE_TIMEOUT_MILLIS = 3000;

    private static ApiService API;

    /**
     * Injects cookies to every request
     */
    private static final Interceptor COOKIES_REQUES_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!TextUtils.isEmpty(getCookie())) {
                request.newBuilder().addHeader("Cookie", getCookie()).build();
            }
            return null;
        }
    };

    static {
//        CookieManager cookieManager = new CookieManager();
//        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        OkHttpClient okHttpClient = new OkHttpClient();

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor(new StethoInterceptor())
//                .connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//                .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//                .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//                .addInterceptor(COOKIES_REQUES_INTERCEPTOR)
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLs.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API = retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        return API;
    }


    public static String getCookie() {
        return AppConfig.getString("api_cookie", "");
    }

    public static void setCookie(String cookie) {
        if (cookie == null) {
            cookie = "";
        }
        AppConfig.putString("api_cookie", cookie);
    }
}
