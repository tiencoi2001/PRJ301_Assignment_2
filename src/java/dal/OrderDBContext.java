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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.RoomType;

/**
 *
 * @author Vu Duc Tien
 */
public class OrderDBContext extends DBContext {

    public Order getOrderByID(int id) {
        try {
            String sql = "SELECT [OrderID],[AccountID],[CheckIN],[CheckOUT],[Name],[Email],[Phone],[NumberOfRooms],o.[TypeID],[TypeName],[Access]\n"
                    + "  FROM [Orders] o\n"
                    + "  join RoomTypes rt on o.TypeID = rt.TypeID\n"
                    + "  where OrderID = ?\n";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt(1));
                order.setAccountID(rs.getInt(2));
                order.setCheckIN(rs.getDate(3));
                order.setCheckOUT(rs.getDate(4));
                order.setName(rs.getString(5));
                order.setEmail(rs.getString(6));
                order.setPhone(rs.getString(7));
                order.setNumberOfRooms(rs.getInt(8));

                RoomType rt = new RoomType();
                rt.setId(rs.getInt(9));
                rt.setName(rs.getString(10));

                order.setRoomType(rt);
                order.setAccess(rs.getBoolean(11));
                return order;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Order> getListOrder(boolean access, Date checkIN, Date checkOUT, int pageSize, int pageIndex, String orderby) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "select OrderID from\n"
                    + "(select ROW_NUMBER() over (order by OrderID asc) as stt, OrderID\n"
                    + "from Orders\n"
                    + "where Access = ?\n";

            int paramIndex = 1;
            HashMap<Integer, Object[]> params = new HashMap<>();

            if (checkIN != null) {
                sql += "and CheckIN >= ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = checkIN;
                params.put(paramIndex, param);
            }
            if (checkOUT != null) {
                sql += "and CheckOUT <= ?\n";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = checkOUT;
                params.put(paramIndex, param);
            }
            sql += ") as t\n"
                    + "where t.stt >= (? - 1) * ? + 1 and t.stt <= ? * ?\n"
                    + "order by OrderID " + orderby;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, access);
            stm.setInt(paramIndex + 1, pageIndex);
            stm.setInt(paramIndex + 2, pageSize);
            stm.setInt(paramIndex + 3, pageIndex);
            stm.setInt(paramIndex + 4, pageSize);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Date.class.getName())) {
                    stm.setDate(index, (Date) value[1]);
                }
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order order = getOrderByID(rs.getInt(1));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalRows(boolean accsess, Date checkIN, Date checkOUT) {
        String sql = "select count(*) as total from\n"
                + "(select ROW_NUMBER() over (order by OrderID asc) as stt\n"
                + "from Orders\n"
                + "where Access = ?\n";

        int paramIndex = 1;
        HashMap<Integer, Object[]> params = new HashMap<>();

        if (checkIN != null) {
            sql += "and CheckIN >= ?\n";
            paramIndex++;
            Object[] param = new Object[2];
            param[0] = Date.class.getName();
            param[1] = checkIN;
            params.put(paramIndex, param);
        }
        if (checkOUT != null) {
            sql += "and CheckOUT <= ?\n";
            paramIndex++;
            Object[] param = new Object[2];
            param[0] = Date.class.getName();
            param[1] = checkOUT;
            params.put(paramIndex, param);
        }

        sql += ") as t\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, accsess);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Date.class.getName())) {
                    stm.setDate(index, (Date) value[1]);
                }
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean insertOrder(Order order) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Orders]\n"
                    + "           ([AccountID],[CheckIN],[CheckOUT],[Name],[Email],[Phone],[NumberOfRooms],[TypeID],[Access])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, order.getAccountID());
            stm.setDate(2, order.getCheckIN());
            stm.setDate(3, order.getCheckOUT());
            stm.setString(4, order.getName());
            stm.setString(5, order.getEmail());
            stm.setString(6, order.getPhone());
            stm.setInt(7, order.getNumberOfRooms());
            stm.setInt(8, order.getRoomType().getId());
            stm.setBoolean(9, false);
            stm.executeUpdate();
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
        ArrayList<Order> orders = new ArrayList<>();
//        orders = odbc.getListOrder(true, Date.valueOf("2022-04-05"), Date.valueOf("2022-04-10"),1,1);
        orders = odbc.getListOrder(true, null, null, 3, 1, "asc");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }
}
