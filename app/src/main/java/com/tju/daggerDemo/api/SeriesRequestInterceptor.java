package com.tju.daggerDemo.api;

import com.tju.daggerDemo.model.managers.AppManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rakshith on 21/03/17.
 */

public class SeriesRequestInterceptor implements Interceptor {
    private final String applicationVersionCode;
    public static final String HEADER_APP_VERSION = "X-SERIES-APP-VERSION";
    public static final String HEADER_AUTH_TOKEN = "X-SERIES-AUTH-TOKEN";



    public SeriesRequestInterceptor(AppManager appManager) {
        this.applicationVersionCode = String.valueOf(appManager.getApplicationVersionCode());
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        final Request.Builder builder = originalRequest.newBuilder();
       // builder.addHeader(HEADER_APP_VERSION, String.valueOf(applicationVersionCode));
        final Request request = builder.build();
        return chain.proceed(request);
    }
}
