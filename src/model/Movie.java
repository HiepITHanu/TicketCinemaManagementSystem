/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BVCN 88
 */
public class Movie {
    private int movieId;
    private String name;
    private String genre;
    private String durationTime;
    private String thumbnail;

    public Movie(int movieId, String name, String genre, String durationTime, String thumbnail) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.durationTime = durationTime;
        this.thumbnail = thumbnail;
    }

    public Movie(String name, String genre, String durationTime, String thumbnail) {
        this.name = name;
        this.genre = genre;
        this.durationTime = durationTime;
        this.thumbnail = thumbnail;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

