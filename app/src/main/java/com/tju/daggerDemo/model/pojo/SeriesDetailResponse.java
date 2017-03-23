package com.tju.daggerDemo.model.pojo;

/**
 * Created by rakshith on 23/03/17.
 */

public class SeriesDetailResponse {
    public SeriesDetailModel getSeriesDetailModel() {
        return seriesDetailModel;
    }

    private final SeriesDetailModel seriesDetailModel;

    public SeriesDetailResponse(SeriesDetailModel seriesDetailModel) {
        this.seriesDetailModel=seriesDetailModel;
    }
}
