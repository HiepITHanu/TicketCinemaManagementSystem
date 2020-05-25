/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author BVCN 88
 */
public class Room {
    private int roomId;
    private String roomName;
    private ArrayList<String> seats;
    private static final int MAXSEAT = 56;

    public Room(int roomId, String roomName, ArrayList<String> seats) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.seats = seats;
    }

    public Room(String roomName, ArrayList<String> seats) {
        this.roomName = roomName;
        this.seats = seats;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }
    
    private boolean isFullSeat(){
        return this.seats.size() >= MAXSEAT;
    }
}
