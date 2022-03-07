/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Vu Duc Tien
 */
public class Order {

    private int orderID;
    private int accountID;
    private Date checkIN;
    private Date checkOUT;
    private String name;
    private String email;
    private String phone;
    private int numberOfRooms;
    private RoomType roomType;
    private boolean access;

    public Order() {
    }

    public Order(int orderID, int accountID, Date checkIN, Date checkOUT, String name, String email, String phone, int numberOfRooms, RoomType roomType, boolean access) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.checkIN = checkIN;
        this.checkOUT = checkOUT;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
        this.access = access;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getCheckIN() {
        return checkIN;
    }

    public void setCheckIN(Date checkIN) {
        this.checkIN = checkIN;
    }

    public Date getCheckOUT() {
        return checkOUT;
    }

    public void setCheckOUT(Date checkOUT) {
        this.checkOUT = checkOUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", accountID=" + accountID + ", checkIN=" + checkIN + ", checkOUT=" + checkOUT + ", name=" + name + ", email=" + email + ", phone=" + phone + ", numberOfRooms=" + numberOfRooms + ", roomType=" + roomType + ", access=" + access + '}';
    }
}