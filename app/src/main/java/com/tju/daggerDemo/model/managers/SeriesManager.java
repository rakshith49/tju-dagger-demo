package com.tju.daggerDemo.model.managers;

import com.squareup.otto.Bus;
import com.tju.daggerDemo.model.pojo.SeriesDetailModel;
import com.tju.daggerDemo.model.pojo.SeriesDetailResponse;
import com.tju.daggerDemo.model.pojo.SeriesResponse;
import com.tju.daggerDemo.model.pojo.SeriesModel;
import com.tju.daggerDemo.utils.RxUtils;
import com.tju.daggerDemo.api.SeriesApi;

import rx.Subscriber;

/**
 * Created by rakshith on 19/03/17.
 */

public class SeriesManager {
    private final RxUtils rxUtils;
    private final Bus bus;
    private final ApiErrorManager apiErrorManager;
    private SeriesApi seriesApi;

    public SeriesManager(RxUtils rxUtils, SeriesApi clearTaxApi, Bus bus, ApiErrorManager
            apiErrorManager) {
        this.rxUtils = rxUtils;
        seriesApi = clearTaxApi;
        this.bus = bus;
        this.apiErrorManager = apiErrorManager;

    }

    public void makeSeriesApiCall() {
        seriesApi.getSeries()
                .compose(rxUtils.applySchedulers())
                .subscribe(new Subscriber<SeriesModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        apiErrorManager.handleError(e);
                    }

                    @Override
                    public void onNext(SeriesModel orderHistoryResponse) {
                        bus.post(new SeriesResponse(orderHistoryResponse));

                    }
                });

    }

    public void makeSeriesDetailApiCall(String imdbID) {
        seriesApi.getSeriesDetails(imdbID)
                .compose(rxUtils.applySchedulers())
                .subscribe(new Subscriber<SeriesDetailModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        apiErrorManager.handleError(e);
                    }

                    @Override
                    public void onNext(SeriesDetailModel seriesDetailModel) {
                        // bus.post(new SeriesDetailResponse(seriesDetailModel));
                        // TODO: 23/03/17  Subscribe this one in DetailSeries screen

                    }
                });


    }
}
