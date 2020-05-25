/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewScheduleMovie;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import model.Movie;
import model.Order;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerScheduleMovie {

    private ViewScheduleMovie vsm;
    private Movie m;
    private JList<String> listSchedule;
    private String selectedSchedule;
    private Order order;

    public ControllerScheduleMovie(Movie m, Order order) {
        vsm = new ViewScheduleMovie();
        this.vsm.setVisible(true);
        this.m = m;
        this.order = order;
        loadData();
        action();
    }

    public void action() {
        vsm.getNextBtn().addActionListener((e) -> {
            selectedSchedule = listSchedule.getSelectedValue();
            
            this.vsm.dispose();
        });

        this.vsm.getBackBtn().addActionListener((e) -> {
            this.vsm.dispose();
        });
    }

    private void loadData() {
        JLabel title = vsm.getTitleLabel();
        title.setText(m.getName());

        staffDao staffDeo = new staffDao();
        ListModel<String> lstSchdule = (ListModel<String>) staffDeo.getSpecificMovieSchedule(m.getMovieId()).getListSchedule();

        listSchedule = vsm.getListSchedule();
        listSchedule.setModel(lstSchdule);

    }

    public String getSelectSchedule() {
        return selectedSchedule;
    }
}
