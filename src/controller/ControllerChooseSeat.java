/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChooseSeat;
import View.ViewScheduleMovie;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Movie;
import model.MovieSchedule;
import model.Room;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerChooseSeat {

    private ViewChooseSeat viewChooseSeat;
    private Room room;
    private ViewScheduleMovie vsm;
    private Movie m;
    private MovieSchedule ms;
    private ArrayList<Room> lstRoom;
    private int numberTicket;
    private String seats;

    public ControllerChooseSeat(ViewScheduleMovie vsm, Movie m, MovieSchedule ms) {
        this.vsm = vsm;
        this.m = m;
        this.ms = ms;
        this.viewChooseSeat = new ViewChooseSeat();
        viewChooseSeat.setVisible(true);
        this.numberTicket = 0;
        loadRoom();
        action();
    }

    private void loadRoom() {
        staffDao staffdao = new staffDao();
        lstRoom = staffdao.getSpecificRoom(ms.getId());

        ArrayList<String> lstNameRoom = new ArrayList<>();

        for (Room r : lstRoom) {
            lstNameRoom.add(r.getRoomName());
        }
        
        DefaultComboBoxModel<String> listModel = new DefaultComboBoxModel<>();
        for (int i = 0; i < lstNameRoom.size(); i++) {
            listModel.addElement(lstNameRoom.get(i));
        }

        viewChooseSeat.getComboBox().setModel(listModel);
        
        room = lstRoom.get(0);
        //ordered seats
        ArrayList<String> orderedSeats = lstRoom.get(0).getOrderedSeat();

        Component[] seatBtns = viewChooseSeat.getArraySeats();

        for (int i = 0; i < seatBtns.length; i++) {
            JButton temp = (JButton) seatBtns[i];
            if (orderedSeats.contains(temp.getText())) {
                temp.setEnabled(false);
            } else {
                temp.setEnabled(true);
            }
//            System.out.println(temp.getText());
        }
    }

    private ArrayList<String> getListSeat() {
        ArrayList<String> seats = new ArrayList<>();
        return seats;
    }

    private void action() {
        JButton nextBtn = this.viewChooseSeat.getNextBtn();
        JButton bacButton = this.viewChooseSeat.getBackBtn();
        JButton reloadBtn = this.viewChooseSeat.getReloadBtn();

        bacButton.addActionListener((e) -> {
            this.vsm.setVisible(true);
            this.viewChooseSeat.dispose();
        });

        nextBtn.addActionListener((e) -> {
            String str = "Number of tickets: " + this.viewChooseSeat.getNumberOfTickets() + "\n" +
                         "Seats: " + this.viewChooseSeat.getSeatLabel() + "\n" +
                         "Room: " + this.viewChooseSeat.getComboBox().getSelectedItem();
            numberTicket = this.viewChooseSeat.getNumberOfTickets();
            seats = this.viewChooseSeat.getSeatLabel();
            int res = JOptionPane.showConfirmDialog(this.viewChooseSeat,str + "\n" + "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(res == JOptionPane.YES_OPTION){
                
                this.viewChooseSeat.setVisible(false);
                ControllerOrderFoodAndDrink fd = new ControllerOrderFoodAndDrink(viewChooseSeat, m, ms, room, numberTicket, seats);
            }
            
        });

        reloadBtn.addActionListener((e) -> {
            this.viewChooseSeat.clearAll();
            String nameCurrentRoom = (String) this.viewChooseSeat.getComboBox().getSelectedItem();
            for (int i = 0; i < lstRoom.size(); i++) {
                if (lstRoom.get(i).getRoomName().equals(nameCurrentRoom)) {
                    Room room = lstRoom.get(i);
                    ArrayList<String> orderedSeats = room.getOrderedSeat();

                    Component[] seatBtns = viewChooseSeat.getArraySeats();

                    for (Component seatBtn : seatBtns) {
                        JButton temp = (JButton) seatBtn;
                        if (orderedSeats.contains(temp.getText())) {
                            temp.setEnabled(false);
                        } else {
                            temp.setEnabled(true);
                        }
//                      System.out.println(temp.getText());
                    }
                }
            }
        });
    }

//    private void highlightChosenSeats(){
//        viewChooseSeat.getListSeat();
//    }
}
