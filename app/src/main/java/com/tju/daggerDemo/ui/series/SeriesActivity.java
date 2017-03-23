package com.tju.daggerDemo.ui.series;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.tju.daggerDemo.ui.BaseActivity;
import com.tju.daggerDemo.R;
import com.tju.daggerDemo.SeriesApplication;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.tju.daggerDemo.model.pojo.SearchModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class SeriesActivity extends BaseActivity implements SeriesContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.contacts_recycler_view)
    FastScrollRecyclerView mSeriesRecycler;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.error)
    TextView error;

    @Inject
    SeriesPresenter mPresenter;
    @Inject
    SeriesAdapter mAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    boolean isFirstLaunch = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.bind(this);
        ((SeriesApplication) getApplication()).getDaggerInjector().inject(this);
        mPresenter.setOnCreate();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.setEventBus();
        if (isFirstLaunch) {
            mPresenter.makeApiCall();
            isFirstLaunch = false;
        }
    }

    @Override
    public void initRecycler() {
        toolbar.setTitle("TJU Dagger Demo");
        mSeriesRecycler.setLayoutManager(mLayoutManager);
        mSeriesRecycler.setAdapter(mAdapter);
        mAdapter.setPresenter(mPresenter);
    }

    @Override
    public void setDatatoRecycler(ArrayList<SearchModel> searchModels) {
        mAdapter.setSeriesList(searchModels);
    }


}
