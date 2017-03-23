package com.tju.daggerDemo.di.components;

import com.tju.daggerDemo.di.modules.SeriesModule;
import com.tju.daggerDemo.ui.series.SeriesActivity;
import com.tju.daggerDemo.model.scopes.ActivityScope;
import com.tju.daggerDemo.di.components.AppComponent;
import dagger.Component;

@ActivityScope
@Component(modules = { SeriesModule.class }, dependencies = { AppComponent.class })
public interface SeriesComponent {
  void inject(SeriesActivity contactsActivity);
}
