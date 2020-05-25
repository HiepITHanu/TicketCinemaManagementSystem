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
    private String urlImg;
    private int scheduleMovieId;

    public Movie(int movieId, String name, String urlImg, int scheduleMovieId) {
        this.movieId = movieId;
        this.name = name;
        this.urlImg = urlImg;
        this.scheduleMovieId = scheduleMovieId;
    }
    

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
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

    public int getScheduleMovieId() {
        return scheduleMovieId;
    }

    public void setScheduleMovieId(int scheduleMovieId) {
        this.scheduleMovieId = scheduleMovieId;
    }
}

