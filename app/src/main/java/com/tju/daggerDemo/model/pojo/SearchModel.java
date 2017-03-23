package com.tju.daggerDemo.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.security.PrivateKey;

/**
 * Created by rakshith on 20/03/17.
 */

public class SearchModel {

    /*   "Title": "Game of Thrones",
               "Year": "2011–",
               "imdbID": "tt0944947",
               "Type": "series",
               "Poster": "https://images-na.ssl-images-amazon.com/images/M/MV5BMjM5OTQ1MTY5Nl5BMl5BanBnXkFtZTgwMjM3NzMxODE@._V1_SX300.jpg"*/
    @SerializedName("Title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    @SerializedName("Year")
    private String year;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String posterImage;


}
