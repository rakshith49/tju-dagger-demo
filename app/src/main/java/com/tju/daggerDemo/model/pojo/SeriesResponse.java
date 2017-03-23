package com.tju.daggerDemo.model.pojo;

/**
 * Created by rakshith on 22/03/17.
 */

public class SeriesResponse {
    public SeriesModel getSeriesModel() {
        return seriesModel;
    }

    private final SeriesModel seriesModel;

    public SeriesResponse(SeriesModel seriesModel) {
        this.seriesModel = seriesModel;

    }
}
