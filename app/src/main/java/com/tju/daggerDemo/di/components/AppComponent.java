package com.tju.daggerDemo.di.components;

import android.content.Context;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.tju.daggerDemo.SeriesApplication;
import com.tju.daggerDemo.api.SeriesApi;
import com.tju.daggerDemo.di.modules.ApiModule;
import com.tju.daggerDemo.di.modules.AppModule;
import com.tju.daggerDemo.model.Model;
import com.tju.daggerDemo.model.managers.ApiErrorManager;
import com.tju.daggerDemo.model.managers.AppManager;
import com.tju.daggerDemo.model.managers.DeviceManager;
import com.tju.daggerDemo.model.managers.SeriesManager;
import com.tju.daggerDemo.model.scopes.PerApp;
import com.tju.daggerDemo.utils.RxUtils;

import dagger.Component;

@PerApp
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface AppComponent {
    SeriesApi provideSeriesApi();

    SeriesApplication provideSeriesApplication();

    SeriesManager provideSeriesManager();

    Context provideContext();

    Model provideModel();

    DeviceManager provideDeviceManager();

    AppManager provideAppManager();

    RxUtils provideRxUtils();

    Bus provideEventBus();

    Gson providesGson();

    ApiErrorManager provideApiErrorManager();

}
