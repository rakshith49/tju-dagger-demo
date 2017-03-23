package com.tju.daggerDemo.ui.series;

import android.os.Bundle;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.tju.daggerDemo.ui.BaseContract;
import com.tju.daggerDemo.ui.BasePresenter;
import com.tju.daggerDemo.model.Model;
import com.tju.daggerDemo.model.pojo.SeriesResponse;
import com.tju.daggerDemo.model.pojo.SearchModel;

public class SeriesPresenter extends BasePresenter implements SeriesContract.Presenter {


    private final SeriesContract.View mView;
    private final Model mModel;
    private final Bus mBus;

    public SeriesPresenter(SeriesContract.View view, Model model, Bus bus) {
        super((BaseContract.View) view, model, bus);
        mView = view;
        mModel = model;
        mBus = bus;

    }

    @Override
    public void saveUIState(Bundle outState) {

    }

    @Override
    public void restoreUIState(Bundle savedInstanceState) {

    }

    @Override
    public void setOnCreate() {
        mView.initRecycler();

    }

    @Override
    public void setEventBus() {
        mBus.register(this);
    }


    @Override
    public void clickedSeriesItem(SearchModel searchModel) {
        //todo handle
    }

    @Override
    public void makeApiCall() {
        mModel.seariesManager.makeSeriesApiCall();
    }

    @Subscribe
    public void onEvent(SeriesResponse seriesResponse) {
        mView.setDatatoRecycler(seriesResponse.getSeriesModel().getSearchModels());
    }
}
