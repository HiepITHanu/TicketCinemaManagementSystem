/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewHistoryOrder;
import View.ViewStaff;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Movie;
import model.Order;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerHistoryOrder {
    private ViewHistoryOrder viewHistoryOrder;
    private ViewStaff viewstaff;
    
    public ControllerHistoryOrder(ViewStaff viewstaff){
        this.viewHistoryOrder = new ViewHistoryOrder();
        this.viewHistoryOrder.setVisible(true);
        this.viewstaff = viewstaff;
        
        generateOrder();
        action();
    }
    
    private void generateOrder(){
        staffDao staffdao = new staffDao();
        ArrayList<Order> lstOrder = staffdao.getAllOrder();
        
        JTable orderTable = this.viewHistoryOrder.getTableOrder();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        orderTable.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Number of tickets");
        defaultTableModel.addColumn("Movie");
        defaultTableModel.addColumn("Total price");
        
        ArrayList<Movie> lstMovie = new ArrayList<Movie>();
        
        for(int i = 0; i < lstOrder.size(); i++){
            Movie temp = staffdao.getSpecificMovie(lstOrder.get(i).getMovieId());
            lstMovie.add(temp);
        }
        
        for(int i = 0; i < lstMovie.size(); i++){
            defaultTableModel.addRow(new Object[] {lstOrder.get(i).getOrderId(), lstOrder.get(i).getNumberTicket(), lstMovie.get(i).getName(), lstOrder.get(i).getTotalPrice()});
        }
    }
    
    private void action(){
        this.viewHistoryOrder.getBackBtn().addActionListener((e) -> {
           this.viewstaff.setVisible(true);
           this.viewHistoryOrder.dispose();
        });
    }
}
