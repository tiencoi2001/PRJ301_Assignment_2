/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author Vu Duc Tien
 */
public class OrderDBContext extends DBContext {

    public boolean insertOrderWait(Order order) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [OrderWaits]\n"
                    + "           ([AccountID],[CheckIN],[CheckOUT],[Name],[Email],[Phone],[NumberOfRooms],[TypeID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, order.getAccountID());
            stm.setDate(2, order.getCheckIN());
            stm.setDate(3, order.getCheckOUT());
            stm.setString(4, order.getName());
            stm.setString(5, order.getEmail());
            stm.setString(6, order.getPhone());
            stm.setInt(7, order.getNumberOfRooms());
            stm.setInt(8, order.getTypeID());
            stm.execute();
            connection.commit();
            return true;
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
        return false;
    }
    
    public static void main(String[] args) {
        OrderDBContext odbc = new OrderDBContext();
        String name = "Vu Duc Tien";
        String email = "tienvdhe153313@fpt.edu.vn";
        String phone = "0983563147";
        Date checkIN = Date.valueOf("2022-02-27");
        Date checkOUT = Date.valueOf("2022-02-28");
        int numberOfRooms = 2;
        int typeID = 2;

        Order order = new Order();
        order.setName(name);
        order.setEmail(email);
        order.setPhone(phone);
        order.setCheckIN(checkIN);
        order.setCheckOUT(checkOUT);
        order.setNumberOfRooms(numberOfRooms);
        order.setTypeID(typeID);
        odbc.insertOrderWait(order);
    }
}
