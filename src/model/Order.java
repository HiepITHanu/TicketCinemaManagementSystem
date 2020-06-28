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
    private int numberTicket;
    private double totalPrice;
    private int movieId;

    public Order(int orderId, int numberTicket, double totalPrice, int movieId) {
        this.orderId = orderId;
        this.numberTicket = numberTicket;
        this.totalPrice = totalPrice;
        this.movieId = movieId;
    }

    public Order(int numberTicket, double totalPrice, int movieId) {
        this.numberTicket = numberTicket;
        this.totalPrice = totalPrice;
        this.movieId = movieId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
