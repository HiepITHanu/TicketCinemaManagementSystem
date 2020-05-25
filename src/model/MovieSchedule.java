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
    private String schedule;
    private int movieId;

    public MovieSchedule(int id, String schedule, int movieId) {
        this.id = id;
        this.schedule = schedule;
        this.movieId = movieId;
        
    }

    public MovieSchedule(String schedule, int movieId) {
        this.schedule = schedule;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSchedule(){
        return schedule;
    }

    public DefaultListModel<String> getListSchedule() {
        String[] listSchedule = this.schedule.split(" ");
        DefaultListModel<String> lstSche = new DefaultListModel<>();
        for(String x : listSchedule){
            lstSche.addElement(x);
        }
        return lstSche;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
}
