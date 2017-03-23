package com.tju.daggerDemo.model.managers;

import com.squareup.otto.Bus;
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
        /*this.userManager = userManager;
        this.apiErrorManager = apiErrorManager;
        this.authenticationErrorManager = authenticationErrorManager;*/
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
}
