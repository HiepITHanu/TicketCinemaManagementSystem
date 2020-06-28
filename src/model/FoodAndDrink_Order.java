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
public class FoodAndDrink_Order {
    private int orderId;
    private int foodId;
    private int quanity;

    public FoodAndDrink_Order(int orderId, int foodId, int quanity) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quanity = quanity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
    
    
}
