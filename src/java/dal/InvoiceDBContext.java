/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;

/**
 *
 * @author Vu Duc Tien
 */
public class InvoiceDBContext extends DBContext {

    public Invoice getInvoiceByID(int id) {
        OrderDBContext odbc = new OrderDBContext();
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

    public ArrayList<Invoice> getListInvoice(boolean paid, int pageSize, int pageIndex, String orderby) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "select InvoiceID from \n"
                    + "(select ROW_NUMBER() over (order by InvoiceID asc) as stt, InvoiceID\n"
                    + "from Invoices\n"
                    + "where Paid = ?) as t\n"
                    + "where t.stt >= (? - 1) * ? + 1 and t.stt <= ? * ?\n"
                    + "order by InvoiceID " + orderby;
            System.out.println(sql);
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
        String sql = "select InvoiceID from \n"
                + "(select ROW_NUMBER() over (order by InvoiceID asc) as stt, InvoiceID\n"
                + "from Invoices\n"
                + "where Paid = ?) as t\n";
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
}
