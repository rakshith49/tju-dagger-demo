package com.tju.daggerDemo.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rakshith on 20/03/17.
 */

public class SeriesModel {
    public ArrayList<SearchModel> getSearchModels() {
        return searchModels;
    }

    public void setSearchModels(ArrayList<SearchModel> searchModels) {
        this.searchModels = searchModels;
    }

    @SerializedName("Search")
    ArrayList<SearchModel> searchModels;

    public String getRespose() {
        return respose;
    }

    public void setRespose(String respose) {
        this.respose = respose;
    }

    @SerializedName("Response")
    private String respose;

}
