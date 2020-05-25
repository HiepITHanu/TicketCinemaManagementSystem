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
public class Admin extends User{
    
    public Admin(int id, String name, String dob, String phoneNumber, Account account) {
        super(id, name, dob, phoneNumber, account);
    }

    public Admin(String name, String dob, String phoneNumber, Account account) {
        super(name, dob, phoneNumber, account);
    }
}
