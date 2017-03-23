package com.tju.daggerDemo.api;

import com.google.gson.Gson;
import com.tju.daggerDemo.model.pojo.SeriesModel;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by rakshith on 20/03/17.
 */

public class SeriesApi {

    private final SeriesApiService mClearTaxApiService;
    public final static int CONNECTION_TIMEOUT = 30;
    public final static int READ_TIMEOUT = 30;
    public final static int WRITE_TIMEOUT = 30;

    public SeriesApi(OkHttpClient okHttpClient, Gson gson, String apiUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mClearTaxApiService = retrofit.create(SeriesApiService.class);
    }

    public SeriesApiService getSeriesApiService() {
        return mClearTaxApiService;
    }

    public Observable<SeriesModel> getSeries() {
        return getSeriesApiService().getSeries();
    }
}
