/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChooseMovies;
import View.ViewScheduleMovie;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Movie;
import model.MovieSchedule;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerScheduleMovie {
    private ViewScheduleMovie vsm;
    private Movie m;
    private String selectedSchedule;
    private ArrayList<MovieSchedule> lstSchdule;
    private MovieSchedule scheduleMovie;
    private ViewChooseMovies viewChooseMovie;

    public ControllerScheduleMovie(Movie m, ViewChooseMovies viewChooseMovie) {
        vsm = new ViewScheduleMovie();
        this.vsm.setVisible(true);
        this.m = m;
        loadData();
        this.viewChooseMovie= viewChooseMovie;
        action();
       
    }

    public void action() {
        vsm.getNextBtn().addActionListener((e) -> {
           selectedSchedule = vsm.getListSchedule().getSelectedValue();
           
            scheduleMovie = lstSchdule.get(vsm.getListSchedule().getSelectedIndex());
            this.vsm.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Schedule: " + selectedSchedule + "\n" + "Click Next to choose seats!");
            ControllerChooseSeat abc = new ControllerChooseSeat(this.vsm ,m, scheduleMovie);
            
        });

        this.vsm.getBackBtn().addActionListener((e) -> {
            this.viewChooseMovie.setVisible(true);
            this.vsm.dispose();
        });
    }

    private void loadData() {
        JLabel title = vsm.getTitleLabel();
        title.setText(m.getName());

        staffDao staffDeo = new staffDao();
        lstSchdule = staffDeo.getSpecificMovieSchedule(m.getMovieId());

        ArrayList<String> time = new ArrayList<>();

        for (MovieSchedule ms : lstSchdule) {
            time.add(ms.getTime());
        }

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < time.size(); i++) {
            listModel.addElement(time.get(i));
        }

        vsm.getListSchedule().setModel(listModel);
        vsm.getListSchedule().setSelectedIndex(0);

    }

}