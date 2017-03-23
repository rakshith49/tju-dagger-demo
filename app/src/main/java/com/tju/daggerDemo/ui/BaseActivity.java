package com.tju.daggerDemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tju.daggerDemo.SeriesApplication;
import com.tju.daggerDemo.di.Injector;

public abstract class BaseActivity extends AppCompatActivity
        implements BaseContract.View {

    BasePresenter mPresenter;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.saveUIState(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.restoreUIState(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.registerForEvents();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.unregisterForEvents();
        }
    }

    protected Injector getDaggerInjector() {
        return ((SeriesApplication) getApplication()).getDaggerInjector();
    }


}
