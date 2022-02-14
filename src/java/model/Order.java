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

    public Order() {
    }

    public Order(int orderID, int accountID, Date checkIN, Date checkOUT, String name, String email, String phone) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.checkIN = checkIN;
        this.checkOUT = checkOUT;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    
}
