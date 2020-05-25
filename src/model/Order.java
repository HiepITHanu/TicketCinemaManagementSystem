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
public class Order {
    private int orderId;
    private MovieSchedule movieSchedule;
    private ExtraOrder exOrder;
    private int numberOfTickets;
    private double totalPrice;
    private int roomId;
    
    public Order(){
        
    }
    public Order(int orderId, MovieSchedule movieSchedule, ExtraOrder exOrder, int numberOfTickets, double totalPrice, int roomId) {
        this.orderId = orderId;
        this.movieSchedule = movieSchedule;
        this.exOrder = exOrder;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.roomId = roomId;
    }

    public Order(MovieSchedule movieSchedule, ExtraOrder exOrder, int numberOfTickets, double totalPrice) {
        this.movieSchedule = movieSchedule;
        this.exOrder = exOrder;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public ExtraOrder getExOrder() {
        return exOrder;
    }

    public void setExOrder(ExtraOrder exOrder) {
        this.exOrder = exOrder;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
}
