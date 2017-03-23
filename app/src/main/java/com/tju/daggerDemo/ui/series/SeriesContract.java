package com.tju.daggerDemo.ui.series;

import com.tju.daggerDemo.model.pojo.SearchModel;

import java.util.ArrayList;

public interface SeriesContract {
    interface View {

        void initRecycler();

        void setDatatoRecycler(ArrayList<SearchModel> searchModels);
    }

    interface Presenter {

        void setOnCreate();

        void setEventBus();

        void clickedSeriesItem(SearchModel searchModel);

        void makeApiCall();
    }

}
