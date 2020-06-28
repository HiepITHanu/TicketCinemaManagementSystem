/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewAdmin;
import View.ViewLogin;
import View.ViewStaff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Account;
import modelDao.adminDao;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerLogin {
    
    private ViewLogin viewLogin;
    
    public ControllerLogin() {
        viewLogin = new ViewLogin();
        viewLogin.setVisible(true);
        login();
    }
    
    public void login() {
        
        viewLogin.getButton_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminDao admindao = new adminDao();
                staffDao staffdao = new staffDao();
                
                Account acc = admindao.getSpecificAccount(viewLogin.getUserName());
                Account acc1 = staffdao.getSpecificAccount(viewLogin.getUserName());
                try {
                    if (acc.getType().equalsIgnoreCase("admin") && acc.getPassword().equals(viewLogin.getUser_passWord())) {
                        viewLogin.dispose();
                        ViewAdmin viewadmin = new ViewAdmin();
                        viewadmin.setVisible(true);
                    } else if (acc1.getType().equalsIgnoreCase("staff") && acc1.getPassword().equals(viewLogin.getUser_passWord())) {
                        viewLogin.dispose();
                        ControllerStaff cStaff = new ControllerStaff(acc1);
                        
                    }                    
                } catch (NullPointerException k) {
                    viewLogin.showAlert();
                }
                
            }
        });
        
    }
    
}
