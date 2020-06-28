/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChooseSeat;
import View.ViewFoodsDrinks;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.FoodAndDrink;
import model.Movie;
import model.MovieSchedule;
import model.Room;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerOrderFoodAndDrink {

    private ViewFoodsDrinks vfd;
    private ViewChooseSeat vms;
    private Movie m;
    private MovieSchedule ms;
    private Room r;
    private int numberTicket;
    private String seats;

    public ControllerOrderFoodAndDrink(ViewChooseSeat vms, Movie m, MovieSchedule ms, Room r, int numberTicket, String seats) {
        this.vfd = new ViewFoodsDrinks();
        this.numberTicket = numberTicket;
        vfd.setVisible(true);
        this.vfd.getJpanel();
        this.vms = vms;
        this.ms = ms;
        this.m = m;
        this.r = r;
        this.seats = seats;
        generateFood();
        action();
    }

    public void generateFood() {
        staffDao staffDao = new staffDao();
        ArrayList<FoodAndDrink> lstFood = staffDao.getAllFoodAndDrinks();

        ArrayList<JLabel> foodNameLabels = this.vfd.getFoodNameLabel();
        ArrayList<JLabel> foodPriceLabels = this.vfd.getFoodPriceLabel();

        for (int i = 0; i < foodNameLabels.size(); i++) {
            foodNameLabels.get(i).setText(lstFood.get(i).getName());
            foodPriceLabels.get(i).setText(String.valueOf(lstFood.get(i).getPrice()));
        }
    }

    public void action() {

        JButton backBtn = this.vfd.getBackBtn();
        JButton skipBtn = this.vfd.getSkipBtn();
        JButton confirmBtn = this.vfd.getNextBtn();

        backBtn.addActionListener((e) -> {
            this.vms.setVisible(true);
            this.vfd.dispose();
        });
        
        
        skipBtn.addActionListener((e) -> {
            ControllerDetailOrder detailOrder = new ControllerDetailOrder(vfd,m, ms, r, numberTicket, seats);
            this.vfd.setVisible(false);
        });

        confirmBtn.addActionListener((e) -> {
            System.out.println("Food");
            ArrayList<Integer> selectedFoodId = new ArrayList<>();
            for (int i = 0; i < this.vfd.getCheckBoxs().size(); i++) {
                if (this.vfd.getCheckBoxs().get(i).isSelected()) {
                    selectedFoodId.add(i + 1);
                }
            }
//            System.out.println(selectedFoodId);
            
            ArrayList<Integer> selectedFoodQuanity = new ArrayList<>();
            for (int i = 0; i < this.vfd.getJpanel().size(); i++) {
                if (this.vfd.getCheckBoxs().get(i).isSelected()) {
                    selectedFoodQuanity.add((Integer) this.vfd.getJpanel().get(i).getValue());
                }
            }
//            System.out.println(selectedFoodQuanity);
            
            ControllerDetailOrder detailOrder = new ControllerDetailOrder(vfd ,m, ms, r,numberTicket,seats, selectedFoodId, selectedFoodQuanity);
            this.vfd.setVisible(false);
        });
    }
}
