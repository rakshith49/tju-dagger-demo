package com.tju.daggerDemo.di.modules;



import android.support.v7.widget.LinearLayoutManager;

import com.squareup.otto.Bus;
import com.tju.daggerDemo.model.Model;
import com.tju.daggerDemo.ui.series.SeriesActivity;
import com.tju.daggerDemo.ui.series.SeriesPresenter;
import com.tju.daggerDemo.model.scopes.ActivityScope;
import com.tju.daggerDemo.ui.series.SeriesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class SeriesModule {

    private final SeriesActivity contactsActivity;

    public SeriesModule(SeriesActivity contactsActivity) {
        this.contactsActivity = contactsActivity;
    }

    @ActivityScope
    @Provides
    SeriesPresenter provideContactsPresenter(Model model,Bus bus) {
        return new SeriesPresenter(contactsActivity, model,bus);
    }

    @ActivityScope
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(contactsActivity, LinearLayoutManager.VERTICAL, false);
    }

    @ActivityScope
    @Provides
    SeriesAdapter provideContactsAdapter() {
        return new SeriesAdapter();
    }
}
