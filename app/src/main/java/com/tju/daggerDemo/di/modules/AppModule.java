package com.tju.daggerDemo.di.modules;

import android.content.Context;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.tju.daggerDemo.di.DateTypeDeserializer;
import com.tju.daggerDemo.model.managers.ApiErrorManager;
import com.tju.daggerDemo.model.Model;
import com.tju.daggerDemo.SeriesApplication;
import com.tju.daggerDemo.model.managers.AppManager;
import com.tju.daggerDemo.model.managers.SeriesManager;

import com.tju.daggerDemo.model.scopes.PerApp;
import com.tju.daggerDemo.model.managers.DeviceManager;
import com.tju.daggerDemo.utils.RxUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tju.daggerDemo.api.SeriesApi;

import java.util.Date;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final SeriesApplication mSeriesApplication;

    public AppModule(SeriesApplication application) {
        mSeriesApplication = application;
    }

    @PerApp
    @Provides
    SeriesApplication provideApplication() {
        return mSeriesApplication;
    }

    @PerApp
    @Provides
    Context provideContext() {
        return mSeriesApplication;
    }


    @PerApp
    @Provides
    Model provideModel(SeriesManager seriesManager) {
        return new Model(seriesManager);
    }

    @PerApp
    @Provides
    DeviceManager provideDeviceManager(Context context) {
        return new DeviceManager(context);
    }


    @PerApp
    @Provides
    RxUtils provideRxUtils() {
        return new RxUtils();
    }

    @PerApp
    @Provides
    ApiErrorManager provideApiErrorManager(Bus bus) {
        return new ApiErrorManager(bus);
    }

    @PerApp
    @Provides
    Bus provideEventBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

    @Provides
    @PerApp
    SeriesManager provideSeriesManager(RxUtils rxUtils, SeriesApi clearTaxApi, Bus bus, ApiErrorManager errorManager) {
        return new SeriesManager(rxUtils, clearTaxApi, bus, errorManager);
    }

    @Provides
    @PerApp
    AppManager provideAppManager(Context context) {
        return new AppManager(context);
    }

    @PerApp
    @Provides
    Gson providesGson(DateTypeDeserializer dateTypeDeserializer) {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, dateTypeDeserializer)
                .enableComplexMapKeySerialization()
                .create();
    }

    @PerApp
    @Provides
    public DateTypeDeserializer provideTypeAdapter() {
        return new DateTypeDeserializer();
    }

}
