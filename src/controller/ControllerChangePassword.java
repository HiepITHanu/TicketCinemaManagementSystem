/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChangePassword;
import javax.swing.JButton;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerChangePassword {
    private ViewChangePassword viewChangePassword;
    private JButton confirm;

    public ControllerChangePassword() {
        viewChangePassword = new ViewChangePassword();
        viewChangePassword.setVisible(true);
       
        
    }
    
    private void submitChangePassword(){
        confirm = viewChangePassword.getConfirmBtn();
         String currentPw = viewChangePassword.getCurrentPwTf().getText();
         String newPw = viewChangePassword.getNewtPwTf().getText();
         String retypePw = viewChangePassword.getRetypePwTf().getText();
         staffDao staff = new staffDao();
         //TODO: back end chua co ham change password
         //check dieu kien truoc.
        
    }
    
    
}
