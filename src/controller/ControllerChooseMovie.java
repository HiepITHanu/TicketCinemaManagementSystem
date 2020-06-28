/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChooseMovies;
import View.ViewStaff;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Movie;
import model.MovieSchedule;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerChooseMovie {

    private ViewChooseMovies viewChooseMovie;
    private staffDao staffDao;
    private ArrayList<Movie> listMovie;
    private int index;
    private ViewStaff viewStaff;
    private ControllerScheduleMovie viewSM;

    public ControllerChooseMovie(ViewStaff viewStaff) {
        this.viewStaff = viewStaff;
        this.viewChooseMovie = new ViewChooseMovies();
        this.viewChooseMovie.setVisible(true);
        this.staffDao = new staffDao();
        this.listMovie = staffDao.getAllMovie();
        this.index = 0;
        action();
    }

    private void action() {
        if (!listMovie.isEmpty()) {
            System.out.println(listMovie.size());
            JLabel img = this.viewChooseMovie.getImgLabel();
            img.setIcon(new ImageIcon(new ImageIcon(this.listMovie.get(index).getThumbnail()).getImage().getScaledInstance(442, 500, Image.SCALE_DEFAULT)));

            JButton nextBtn = this.viewChooseMovie.getNextBtn();
            JButton previousBtn = this.viewChooseMovie.getPreviousButton();
            System.out.println(index);
            nextBtn.addActionListener((e) -> {
                System.out.println(index);
                if (index < this.listMovie.size() - 1) {
                    index++;
                    img.setIcon(new ImageIcon(new ImageIcon(this.listMovie.get(index).getThumbnail()).getImage().getScaledInstance(442, 500, Image.SCALE_DEFAULT)));
                }
            });

            previousBtn.addActionListener((e) -> {
                System.out.println(index);
                if (index > 0 && index < this.listMovie.size()) {
                    index--;
                    img.setIcon(new ImageIcon(new ImageIcon(this.listMovie.get(index).getThumbnail()).getImage().getScaledInstance(442, 500, Image.SCALE_DEFAULT)));
                }
            });

            this.viewChooseMovie.getBackBtn().addActionListener((e) -> {
                this.viewChooseMovie.dispose();
                this.viewStaff.setVisible(true);
            });

            this.viewChooseMovie.getBookButton().addActionListener((e) -> {
                Movie m = listMovie.get(index);
                this.viewChooseMovie.setVisible(false);
//                System.out.println(m.getMovieId());
                viewSM = new ControllerScheduleMovie(m, viewChooseMovie);
              
            });
        }
    }

}
