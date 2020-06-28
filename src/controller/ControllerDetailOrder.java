/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewDetailOrder;
import View.ViewFoodsDrinks;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.FoodAndDrink;
import model.Movie;
import model.MovieSchedule;
import model.Order;
import model.Room;
import model.FoodAndDrink_Order;

import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerDetailOrder {

    private ViewDetailOrder viewDetailOrder;
    private Movie m;
    private MovieSchedule ms;
    private Room r;
    private ArrayList<Integer> selectedFoodId;
    private ArrayList<Integer> selectedFoodQuanity;
    private ViewFoodsDrinks vfd;
    private int numberTicket;
    private String seats;
    private Order order;

    public ControllerDetailOrder(ViewFoodsDrinks vfd, Movie m, MovieSchedule ms, Room r, int numberTicket, String seats, ArrayList<Integer> selectedFoodId, ArrayList<Integer> selectedFoodQuanity) {
        this.viewDetailOrder = new ViewDetailOrder();
        this.viewDetailOrder.setVisible(true);
        this.vfd = vfd;
        this.numberTicket = numberTicket;
        this.m = m;
        this.ms = ms;
        this.r = r;
        this.seats = seats;
        this.selectedFoodId = selectedFoodId;
        this.selectedFoodQuanity = selectedFoodQuanity;

        if (selectedFoodId.isEmpty()) {
            this.viewDetailOrder.getPriceFoodLabel().setText("0");
            generateOrder();
        } else {
            generateFood();
            generateOrder();
        }
        action();
    }

    public ControllerDetailOrder(ViewFoodsDrinks vfd, Movie m, MovieSchedule ms, Room r, int numberTicket, String seats) {
        this.viewDetailOrder = new ViewDetailOrder();
        this.viewDetailOrder.setVisible(true);
        this.vfd = vfd;
        this.numberTicket = numberTicket;
        this.m = m;
        this.ms = ms;
        this.r = r;
        this.seats = seats;

        this.viewDetailOrder.getPriceFoodLabel().setText("0");
        generateOrder();
        action();
    }

    private void generateOrder() {
        this.viewDetailOrder.getNumberTicketLabel().setText(String.valueOf(numberTicket));
        this.viewDetailOrder.getPriceTicketLabel().setText(String.valueOf(numberTicket * 3));
        this.viewDetailOrder.getMovieLabel().setText(m.getName());
        this.viewDetailOrder.getRoomLabel().setText(r.getRoomName());
        this.viewDetailOrder.getSeatLabel().setText(seats);
        this.viewDetailOrder.getScheduleLabel().setText(ms.getTime());
        double totalPrice = Double.parseDouble(this.viewDetailOrder.getPriceTicketLabel().getText()) + Double.parseDouble(this.viewDetailOrder.getPriceFoodLabel().getText());
        this.viewDetailOrder.getTotalPriceLabel().setText(String.valueOf(totalPrice));
    }

    private void generateFood() {
        staffDao staffdao = new staffDao();

        double foodPrice = 0;

        for (int i = 0; i < this.selectedFoodId.size(); i++) {
            FoodAndDrink temp = staffdao.getSpecificFoodAndDrink(selectedFoodId.get(i));
            foodPrice += this.selectedFoodQuanity.get(i) * temp.getPrice();

        }

        this.viewDetailOrder.getPriceFoodLabel().setText(String.valueOf(foodPrice));
        this.viewDetailOrder.getDetailFoodBtn().addActionListener((e) -> {

            String foodOrder = String.format("%30s %25s %10s %25s %10s %25s %10s", "Item", "|", "Price($)", "|", "Qty", "|", "Total($)");
            foodOrder += String.format("\n");
            foodOrder += String.format("%s", "----------------------------------------------------------------------------------------------------------------");
            foodOrder += String.format("\n");

            for (int i = 0; i < this.selectedFoodId.size(); i++) {
                FoodAndDrink temp = staffdao.getSpecificFoodAndDrink(selectedFoodId.get(i));
                foodOrder += String.format("%30s %25s %10.2f %25s %10s %25s %10.2f", temp.getName(), "|", temp.getPrice(), "|", this.selectedFoodQuanity.get(i), "|", (temp.getPrice() * this.selectedFoodQuanity.get(i)));
                foodOrder += String.format("\n");
            }
            JOptionPane.showMessageDialog(viewDetailOrder, foodOrder);
        });
    }

    private void action() {
        JButton backBtn = this.viewDetailOrder.getBackBtn();

        backBtn.addActionListener((e) -> {
            this.vfd.setVisible(true);
            this.viewDetailOrder.dispose();
        });

        this.viewDetailOrder.getSaveBtn().addActionListener((e) -> {
            int res = JOptionPane.showConfirmDialog(this.viewDetailOrder, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (res == JOptionPane.YES_OPTION) {
                staffDao staffdao = new staffDao();
                
                Order newOrder = new Order(numberTicket, Double.parseDouble(this.viewDetailOrder.getTotalPriceLabel().getText()), m.getMovieId());
                System.out.println(newOrder.getNumberTicket()+" "+ newOrder.getTotalPrice()+" "+ newOrder.getMovieId());
                
                staffdao.insertOrder(newOrder);
                
                String [] orderedSeat = this.viewDetailOrder.getSeatLabel().getText().split(" ");
                ArrayList<String> newOrderedSeats = this.r.getOrderedSeat();
                
                for(String x : orderedSeat){
                    newOrderedSeats.add(x);
                }
                
                this.r.setOrderedSeat(newOrderedSeats);
                
                String strOrderedSeats = "";
                for(int i = 0; i< this.r.getOrderedSeat().size(); i++){
                    strOrderedSeats += (this.r.getOrderedSeat().get(i) + " ");
                }
                
                staffdao.updateARoom(this.r.getRoomId(), strOrderedSeats);

                this.order = new Order(numberTicket, Double.parseDouble(this.viewDetailOrder.getTotalPriceLabel().getText()), m.getMovieId());
                ArrayList<Order> lstOrder = staffdao.getAllOrder();

                for (int i = 0; i < this.selectedFoodId.size(); i++) {
                    FoodAndDrink_Order temp = new FoodAndDrink_Order(lstOrder.get(lstOrder.size() - 1).getOrderId(), this.selectedFoodId.get(i), this.selectedFoodQuanity.get(i));
                    staffdao.insertFoodAndDrink_Order(temp);
                }
                
                JOptionPane.showMessageDialog(this.viewDetailOrder, "Successfully!");
                
            }

        });
    }
}
