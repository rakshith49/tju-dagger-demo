package com.tju.daggerDemo.di.modules;

import com.google.gson.Gson;
import com.tju.daggerDemo.R;
import com.tju.daggerDemo.SeriesApplication;

import com.tju.daggerDemo.api.SeriesRequestInterceptor;
import com.tju.daggerDemo.model.managers.AppManager;
import com.tju.daggerDemo.model.scopes.PerApp;
import com.tju.daggerDemo.api.SeriesApi;
import com.tju.daggerDemo.utils.SeriesBuildTypeConfig;


import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by rakshith on 20/03/17.
 */
@Module
public class ApiModule {

    @PerApp
    @Provides
    SeriesApi provideSeriesApi(SeriesApplication application, OkHttpClient okHttpClient,
                               Gson gson) {
        String apiUrl = application.getResources().getString(R.string.cleartax_api_url);
        return new SeriesApi(okHttpClient, gson, apiUrl);
    }


    @PerApp
    @Provides
    OkHttpClient providesOkHttpClient(SeriesRequestInterceptor requestInterceptor,
                                      HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(requestInterceptor);
        builder.addInterceptor(loggingInterceptor);
        builder.connectTimeout(SeriesApi.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(SeriesApi.WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(SeriesApi.READ_TIMEOUT, TimeUnit.SECONDS);
        return builder.build();
    }

    @PerApp
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(SeriesBuildTypeConfig.isDebug() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }


    @PerApp
    @Provides
    SeriesRequestInterceptor providesClearTaxRequestInterceptor(AppManager appManager) {
        return new SeriesRequestInterceptor(appManager);
    }
}
