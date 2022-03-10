/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;
import model.Order;

/**
 *
 * @author Vu Duc Tien
 */
public class InvoiceDBContext extends DBContext {

    public Invoice getInvoiceByID(int id) {
        OrderDBContext odbc = new OrderDBContext();
        RoomDBContext rdbc = new RoomDBContext();
        try {
            String sql = "SELECT [InvoiceID],[OrderID],[AccountID],[Price],[Paid]\n"
                    + "  FROM [Invoices]\n"
                    + "  where InvoiceID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceID(id);
                invoice.setOrder(rdbc.getRoomsByOrderID(odbc.getOrderByID(rs.getInt(2))));
                invoice.setAccountID(rs.getInt(3));
                invoice.setPrice(rs.getDouble(4));
                invoice.setPaid(rs.getBoolean(5));
                return invoice;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Invoice getInvoiceByOrderID(int id) {
        OrderDBContext odbc = new OrderDBContext();
        try {
            String sql = "SELECT [InvoiceID],[OrderID],[AccountID],[Price],[Paid]\n"
                    + "  FROM [Invoices]\n"
                    + "  where OrderID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceID(id);
                invoice.setOrder(odbc.getOrderByID(rs.getInt(2)));
                invoice.setAccountID(rs.getInt(3));
                invoice.setPrice(rs.getDouble(4));
                invoice.setPaid(rs.getBoolean(5));
                return invoice;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Invoice> getInvoiceByAccountID(int id) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        OrderDBContext odbc = new OrderDBContext();
        RoomDBContext rdbc = new RoomDBContext();
        try {
            String sql = "SELECT [InvoiceID],[OrderID],[AccountID],[Price],[Paid]\n"
                    + "  FROM [Invoices]\n"
                    + "  where AccountID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceID(id);
                invoice.setOrder(rdbc.getRoomsByOrderID(odbc.getOrderByID(rs.getInt(2))));
                invoice.setAccountID(rs.getInt(3));
                invoice.setPrice(rs.getDouble(4));
                invoice.setPaid(rs.getBoolean(5));
                invoices.add(invoice);
            }
            return invoices;
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Invoice> getListInvoice(boolean paid, int pageSize, int pageIndex, String orderby) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "select InvoiceID from \n"
                    + "(select ROW_NUMBER() over (order by InvoiceID " + orderby + ") as stt, InvoiceID\n"
                    + "from Invoices\n"
                    + "where Paid = ?"
                    + ") as t\n"
                    + "where t.stt >= (? - 1) * ? + 1 and t.stt <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, paid);
            stm.setInt(2, pageIndex);
            stm.setInt(3, pageSize);
            stm.setInt(4, pageIndex);
            stm.setInt(5, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Invoice invoice = getInvoiceByID(rs.getInt(1));
                invoices.add(invoice);
            }
            return invoices;
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalRows(boolean paid) {
        String sql = "select count(*) as total from\n"
                + "(select ROW_NUMBER() over (order by InvoiceID asc) as stt, InvoiceID\n"
                + "from Invoices\n"
                + "where Paid = ?) as t";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, paid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void insertInvoice(Order order) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Invoices]([OrderID],[AccountID],[Price],[Paid])\n"
                    + "     VALUES (?,?,DATEDIFF(day, ?, ?) * (select price from RoomTypes where TypeID = ?) * ?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, order.getOrderID());
            if (order.getAccountID() != 0) {
                stm.setInt(2, order.getAccountID());
            } else {
                stm.setString(2, null);
            }
            stm.setDate(3, order.getCheckIN());
            stm.setDate(4, order.getCheckOUT());
            stm.setInt(5, order.getRoomType().getId());
            stm.setInt(6, order.getNumberOfRooms());
            stm.setBoolean(7, false);
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        public void updateInvoice(Order order, Invoice invoice) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Invoices]\n"
                    + "   SET [Price] = DATEDIFF(day, ?, ?) * (select price from RoomTypes where TypeID = ?) * ?\n"
                    + " WHERE InvoiceID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, order.getCheckIN());
            stm.setDate(2, order.getCheckOUT());
            stm.setInt(3, order.getRoomType().getId());
            stm.setInt(4, order.getNumberOfRooms());
            stm.setInt(5, invoice.getInvoiceID());
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pay(int invoiceID) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Invoices]\n"
                    + "   SET [Paid] = 'true'\n"
                    + " WHERE InvoiceID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, invoiceID);
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        InvoiceDBContext idbc = new InvoiceDBContext();
        int a = idbc.getTotalRows(true);
        System.out.println(a);
    }
}
