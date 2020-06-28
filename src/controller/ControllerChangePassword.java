/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.ViewChangePassword;
import javax.swing.JButton;
import model.Account;
import modelDao.staffDao;

/**
 *
 * @author BVCN 88
 */
public class ControllerChangePassword {

    private ViewChangePassword viewChangePassword;
    private JButton confirm;
    private Account staff;

    public ControllerChangePassword(Account staff) {
        viewChangePassword = new ViewChangePassword();
        viewChangePassword.setVisible(true);
        this.staff = staff;
        submitChangePassword();
    }

    private void submitChangePassword() {

        confirm = viewChangePassword.getConfirmBtn();

        confirm.addActionListener((e) -> {
            String currentPw = viewChangePassword.getCurrentPwTf().getText();
            String newPw = viewChangePassword.getNewtPwTf().getText();
            String retypePw = viewChangePassword.getRetypePwTf().getText();
            staffDao staff = new staffDao();

            if (newPw.equals(retypePw) && currentPw.equals(this.staff.getPassword())) {
                staff.updatePasswordAccount(this.staff.getUsername(), newPw);
                viewChangePassword.showAlertOk();
            } else {
                viewChangePassword.showAlertFail();
            }
        });
    }

}
