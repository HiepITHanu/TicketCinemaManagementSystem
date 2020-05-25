/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author BVCN 88
 */
public class ExtraOrder {
    private int extraOrderId;
    private ArrayList<FoodAndDrink> listExtraOrder;

    public ExtraOrder(int extraOrderId, ArrayList<FoodAndDrink> listExtraOrder) {
        this.extraOrderId = extraOrderId;
        this.listExtraOrder = listExtraOrder;
    }

    public ExtraOrder(ArrayList<FoodAndDrink> listExtraOrder) {
        this.listExtraOrder = listExtraOrder;
    }

    public int getExtraOrderId() {
        return extraOrderId;
    }

    public void setExtraOrderId(int extraOrderId) {
        this.extraOrderId = extraOrderId;
    }

    public ArrayList<FoodAndDrink> getListExtraOrder() {
        return listExtraOrder;
    }

    public void setListExtraOrder(ArrayList<FoodAndDrink> listExtraOrder) {
        this.listExtraOrder = listExtraOrder;
    }
    
}
