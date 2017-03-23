package com.tju.daggerDemo.api;

import com.tju.daggerDemo.model.pojo.SeriesModel;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by rakshith on 20/03/17.
 */

public interface SeriesApiService {

    @GET("/?s=Game%20of%20Thrones")
    Observable<SeriesModel> getSeries();
}
