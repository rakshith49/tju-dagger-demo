package com.tju.daggerDemo;

import android.app.Application;

import com.tju.daggerDemo.di.DaggerInjectorImpl;

public class SeriesApplication extends Application {

    private static DaggerInjectorImpl sDaggerInjector;

    public SeriesApplication() {
        initDagger();
    }

    public void initDagger() {
        getDaggerInjector().init(this);
    }

    public DaggerInjectorImpl getDaggerInjector() {
        if (sDaggerInjector == null) {
            sDaggerInjector = new DaggerInjectorImpl();
        }
        return sDaggerInjector;
    }
}
