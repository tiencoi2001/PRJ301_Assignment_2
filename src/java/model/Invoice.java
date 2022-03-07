/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vu Duc Tien
 */
public class Invoice {
    private int invoiceID;
    private Order order;
    private int accountID;
    private double price;
    private boolean paid;

    public Invoice() {
    }

    public Invoice(int invoiceID, Order order, int accountID, double price, boolean paid) {
        this.invoiceID = invoiceID;
        this.order = order;
        this.accountID = accountID;
        this.price = price;
        this.paid = paid;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
