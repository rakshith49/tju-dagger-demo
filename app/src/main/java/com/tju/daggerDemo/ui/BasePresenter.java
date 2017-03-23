package com.tju.daggerDemo.ui;

import android.os.Bundle;

import com.squareup.otto.Bus;
import com.tju.daggerDemo.model.Model;
import com.tju.daggerDemo.ui.BaseContract;

public abstract class BasePresenter implements BaseContract.Presenter {


    private final Model model;
    private final BaseContract.View view;
    private final Bus bus;

    public BasePresenter(BaseContract.View view, Model model, Bus bus) {
        this.view = view;
        this.model = model;
        this.bus = bus;
    }


    @Override
    public void registerForEvents() {
        bus.register(this);
    }

    @Override
    public void unregisterForEvents() {
        bus.unregister(this);
    }

    @Override
    public abstract void saveUIState(Bundle outState);


    @Override
    public abstract void restoreUIState(Bundle savedInstanceState);


}
