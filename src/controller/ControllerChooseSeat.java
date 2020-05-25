/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChooseMovies;
import View.ViewChooseSeat;
import java.util.ArrayList;
import javax.swing.JButton;
import model.Room;

/**
 *
 * @author BVCN 88
 */
public class ControllerChooseSeat {
    private ViewChooseSeat viewChooseSeat;
    private Room room;
    private ViewChooseMovies vm;
    
    public ControllerChooseSeat(ViewChooseMovies vm){
        this.vm = vm;
        this.viewChooseSeat = new ViewChooseSeat();
        viewChooseSeat.setVisible(true);
        this.room = createRoom();
        action();
    }
    
    private ArrayList<String> getListSeat(){
        ArrayList<String> seats = new ArrayList<>();
        return seats;
    }
    
    private Room createRoom(){
        Room room = new Room((String) this.viewChooseSeat.getComboBox().getSelectedItem(), this.viewChooseSeat.getListSeat());
        return room;
    }
    
    private void action(){
        JButton nextBtn = this.viewChooseSeat.getNextBtn();
        JButton bacButton = this.viewChooseSeat.getBackBtn();
        
        bacButton.addActionListener((e) -> {
            this.vm.setVisible(true);
            this.viewChooseSeat.dispose();
        });
        
        nextBtn.addActionListener((e) -> {
            this.viewChooseSeat.setVisible(false);
            ControllerOrderFoodAndDrink fd = new ControllerOrderFoodAndDrink();
        });
    }
}
