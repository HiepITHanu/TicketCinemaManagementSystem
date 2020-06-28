/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author BVCN 88
 */
public class MovieSchedule {
    private int id;
    private String time;
    private int movieId;

    public MovieSchedule(int id, String time, int movieId) {
        this.id = id;
        this.time = time;
        this.movieId = movieId;
        
    }

    public MovieSchedule(String time, int movieId) {
        this.time = time;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTime(){
        return time;
    }

    public DefaultListModel<String> getListSchedule() {
        String[] listSchedule = this.time.split(" ");
        DefaultListModel<String> lstSche = new DefaultListModel<>();
        for(String x : listSchedule){
            lstSche.addElement(x);
        }
        return lstSche;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
}
