/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewStaff;
import model.Movie;

/**
 *
 * @author BVCN 88
 */
public class ControllerOrder {
    private ViewStaff viewStaff;
    public ControllerOrder(ViewStaff viewStaff){
        this.viewStaff=viewStaff;
        
        chooseMovie();
    }
    
    private void chooseMovie(){
        ControllerChooseMovie choseMovie = new ControllerChooseMovie(viewStaff);
        
    }
}
