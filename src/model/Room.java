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
    private ArrayList<String> orderedSeat;
    private int scheduleId;
    private static final int MAXSEAT = 56;

    public Room(int roomId, String roomName, ArrayList<String> orderedSeat, int scheduleId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.orderedSeat = orderedSeat;
        this.scheduleId = scheduleId;
    }

    public Room(String roomName, ArrayList<String> orderedSeat, int scheduleId) {
        this.roomName = roomName;
        this.orderedSeat = orderedSeat;
        this.scheduleId = scheduleId;
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

    public ArrayList<String> getOrderedSeat() {
        return orderedSeat;
    }

    public void setOrderedSeat(ArrayList<String> orderedSeat) {
        this.orderedSeat = orderedSeat;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
