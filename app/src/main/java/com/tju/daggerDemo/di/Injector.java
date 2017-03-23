package com.tju.daggerDemo.di;

import com.tju.daggerDemo.SeriesApplication;
import com.tju.daggerDemo.ui.series.SeriesActivity;

public interface Injector {
    void init(SeriesApplication application);

    void inject(SeriesActivity contactsActivity);
}
