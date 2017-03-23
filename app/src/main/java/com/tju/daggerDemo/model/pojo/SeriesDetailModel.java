package com.tju.daggerDemo.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rakshith on 23/03/17.
 */

public class SeriesDetailModel {
   /* "Title": "Game of Thrones: A Telltale Games Series",
            "Year": "2014",
            "Rated": "N/A",
            "Released": "02 Dec 2014",
            "Runtime": "N/A",
            "Genre": "Adventure, Drama, Fantasy",
            "Director": "Jason Latino, Martin Montgomery, Kent Mudle, Graham Ross",
            "Writer": "Andrew Grant, Ryan Kaufman, George R.R. Martin (novels), Brad Kane, Chris Hockabout, John Dombrow, Meghan Thornton, Justin Sloan, Dan Martin, Joe Pinney, Matt Allmer, Nicole Martinez, Joe Ching",
            "Actors": "Lena Headey, Natalie Dormer, Peter Dinklage, Iwan Rheon",
            "Plot": "During the War of the Five Kings, House Forrester finds themselves embroiled in a web of deceit and corruption.",
            "Language": "English",
            "Country": "USA",
            "Awards": "N/A",
            "Poster": "http://ia.media-imdb.com/images/M/MV5BYmY5ZjFkOTMtMWYxYy00ZjllLTg5MWMtYTA0OTU3YTNkNmExXkEyXkFqcGdeQXVyMjA1MTA1NDQ@._V1_SX300.jpg",
            "Metascore": "N/A",
            "imdbRating": "9.0",
            "imdbVotes": "1,341",
            "imdbID": "tt3391176",
            "Type": "game",
            "Response": "True"*/

   @SerializedName("Title")
    private String title;

    @SerializedName("Released")
    private String released;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @SerializedName("Director")
    private String director;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Actors")
    private String actors;





}
