/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChangePassword;
import View.ViewStaff;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Account;
import model.Order;

/**
 *
 * @author BVCN 88
 */
public class ControllerStaff {

    private ViewStaff viewStaff;
    private Account staff;
    private JButton logOut;
    private JButton order;
    private JButton showOrderHistory;
    private JButton changePassword;
    private JButton profile;

    public ControllerStaff(Account staff) {
        this.viewStaff = new ViewStaff();
        this.viewStaff.setVisible(true);

        this.staff = staff;
        setInformation();
        actionStaff();
    }

    private void setInformation() {
        this.viewStaff.getUsernameLabel().setText(this.staff.getUsername());
    }


    private void actionStaff() {
        logOut = viewStaff.getLogOut();
        order = viewStaff.getOrderBtn();
        showOrderHistory = viewStaff.getHistoryOrderBtn();
        changePassword = viewStaff.getChangePassword();

        changePassword.addActionListener((v1) -> {
            ControllerChangePassword controllerChangePassword = new ControllerChangePassword(staff);
        });

        logOut.addActionListener((v3 -> {
            this.viewStaff.dispose();
            ControllerLogin login = new ControllerLogin();
        }));

        showOrderHistory.addActionListener((v4) -> {
            this.viewStaff.setVisible(false);
            ControllerHistoryOrder cHo = new ControllerHistoryOrder(this.viewStaff);

        });
        order.addActionListener((v4) -> {
            this.viewStaff.setVisible(false);
            ControllerOrder corder = new ControllerOrder(this.viewStaff);
           
        });
    }
}
