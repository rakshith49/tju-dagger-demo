package com.tju.daggerDemo.di;


import com.tju.daggerDemo.SeriesApplication;
import com.tju.daggerDemo.di.components.AppComponent;
import com.tju.daggerDemo.di.components.DaggerAppComponent;
import com.tju.daggerDemo.di.components.DaggerSeriesComponent;
import com.tju.daggerDemo.di.modules.ApiModule;
import com.tju.daggerDemo.di.modules.AppModule;
import com.tju.daggerDemo.ui.series.SeriesActivity;

import com.tju.daggerDemo.di.modules.SeriesModule;

public class DaggerInjectorImpl implements Injector {

    private static AppComponent sAppComponent;

    @Override
    public void init(SeriesApplication application) {
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .apiModule(new ApiModule())
                .build();
    }

    @Override
    public void inject(SeriesActivity seriesActivity) {
        DaggerSeriesComponent.builder()
                .appComponent(sAppComponent)
                .seriesModule(new SeriesModule(seriesActivity))
                .build()
                .inject(seriesActivity);
    }


}
