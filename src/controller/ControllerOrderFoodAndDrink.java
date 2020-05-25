/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewFoodsDrinks;
import java.util.ArrayList;
import javax.swing.JTable;
import model.FoodAndDrink;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerOrderFoodAndDrink {
    private ViewFoodsDrinks vfd;
    
    public ControllerOrderFoodAndDrink(){
        this.vfd = new ViewFoodsDrinks();
        vfd.setVisible(true);
    }
    
    public void generateFood(){
        JTable table = vfd.getFoodTable();
        
        staffDao sD = new staffDao();
        
        ArrayList<FoodAndDrink> listFood = sD.getAllFoodAndDrinks();
        
        
    }
}
