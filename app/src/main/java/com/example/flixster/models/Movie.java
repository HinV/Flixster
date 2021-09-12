package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// part 3.2

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overView;

    public Movie(JSONObject jsonObject) throws JSONException{
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath= jsonObject.getString("poster_path");
        title= jsonObject.getString("title");
        overView= jsonObject.getString("overview");

    }// end Movie

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();

        for( int i=0; i<movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;

    }// end public

    public String getPosterPath() {

        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    // add PosterPath
    public String getBackdropPath(){
        return  String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getTitle() {

        return title;
    }

    public String getOverView() {

        return overView;
    }


}// end Movie class
