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
public class Account {
    private String username;
    private String password;
    private String type;
    private int userId;

    public Account(String username, String password, String type, int userId) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.userId = userId;
    }

    public Account(String password, String type, int userId) {
        this.password = password;
        this.type = type;
        this.userId = userId;
    }
    
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
