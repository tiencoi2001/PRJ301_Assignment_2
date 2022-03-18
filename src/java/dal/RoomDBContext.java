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
import model.Order;
import model.Room;
import model.RoomType;
import model.User;

/**
 *
 * @author Vu Duc Tien
 */
public class RoomDBContext extends DBContext {

    public ArrayList<RoomType> getAllRoomType() {
        ArrayList<RoomType> roomTypes = new ArrayList<>();
        try {
            String sql = "SELECT [TypeID],[TypeName],[Price] FROM [RoomTypes]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(rs.getInt(1));
                roomType.setName(rs.getString(2));
                roomType.setPrice(rs.getDouble(3));
                roomTypes.add(roomType);
            }
            return roomTypes;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Room> getRooms(Order order) {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT [RoomID],[RoomName],[TypeID]  \n"
                    + "FROM [Rooms]  \n"
                    + "where RoomID not in (   \n"
                    + "select RoomID from Orders o   \n"
                    + "join Order_Room ro on ro.OrderID = o.OrderID   \n"
                    + "where ((o.CheckIN <= ? and o.CheckOUT >= ?)  \n"
                    + "or (o.CheckIN <= ? and o.CheckOUT >= ?)\n"
                    + "or (o.CheckIN >= ? and o.CheckOUT <= ?)) \n"
                    + "and o.TypeID = ?)\n"
                    + "and TypeID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, order.getCheckIN());
            stm.setDate(2, order.getCheckIN());
            stm.setDate(3, order.getCheckOUT());
            stm.setDate(4, order.getCheckOUT());
            stm.setDate(5, order.getCheckIN());
            stm.setDate(6, order.getCheckOUT());
            stm.setInt(7, order.getRoomType().getId());
            stm.setInt(8, order.getRoomType().getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                rooms.add(r);
            }
            return rooms;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Room> getRoomsToChange(Order order) {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT [RoomID],[RoomName],[TypeID] \n"
                    + "FROM [Rooms] \n"
                    + "where RoomID not in (  \n"
                    + "select RoomID from Orders o  \n"
                    + "join Order_Room ro on ro.OrderID = o.OrderID  \n"
                    + "where ((o.CheckIN <= ? and o.CheckOUT >= ?) \n"
                    + "or (o.CheckIN <= ? and o.CheckOUT >= ?)\n"
                    + "or (o.CheckIN >= ? and o.CheckOUT <= ?)) \n"
                    + "and o.TypeID = ? and ro.OrderID <> ?)  \n"
                    + "and TypeID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, order.getCheckIN());
            stm.setDate(2, order.getCheckIN());
            stm.setDate(3, order.getCheckOUT());
            stm.setDate(4, order.getCheckOUT());
            stm.setDate(5, order.getCheckIN());
            stm.setDate(6, order.getCheckOUT());
            stm.setInt(7, order.getRoomType().getId());
            stm.setInt(8, order.getOrderID());
            stm.setInt(9, order.getRoomType().getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                rooms.add(r);
            }
            return rooms;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setRooms(int orderID, String[] rooms) {
        try {
            connection.setAutoCommit(false);

            String sql1 = "DELETE FROM [Order_Room] where OrderID = ?";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setInt(1, orderID);
            stm1.executeUpdate();

            for (String room : rooms) {
                String sql2 = "INSERT INTO [Order_Room]([OrderID],[RoomID])\n"
                        + "     VALUES(?,?)";
                PreparedStatement stm2 = connection.prepareStatement(sql2);
                stm2.setInt(1, orderID);
                stm2.setInt(2, Integer.parseInt(room));
                stm2.executeUpdate();
            }

            String sql3 = "UPDATE [Orders] SET [Access] = 'true' WHERE OrderID = ?";
            PreparedStatement stm3 = connection.prepareStatement(sql3);
            stm3.setInt(1, orderID);
            stm3.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Order getRoomsByOrderID(Order order) {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT r.RoomID, RoomName FROM [Order_Room] ro\n"
                    + "join Rooms r on ro.RoomID = r.RoomID\n"
                    + "where OrderID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, order.getOrderID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt(1));
                room.setName(rs.getString(2));
                rooms.add(room);
            }
            order.setRooms(rooms);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    public Room getRoomsByID(int id) {
        try {
            String sql = "SELECT [RoomID],[RoomName],[TypeID]\n"
                    + "  FROM [Rooms] where RoomID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt(1));
                room.setName(rs.getString(2));
                return room;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public void insertRoom(String name, int num){
//        try {
//            connection.setAutoCommit(false);
//            String sql = "INSERT INTO [Rooms] ([RoomName],[TypeID]) VALUES (?,?)";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, name);
//            stm.setInt(2, num);
//            stm.executeUpdate();
//            connection.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
//            try {
//                connection.rollback();
//            } catch (SQLException ex1) {
//                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        } finally {
//            try {
//                connection.setAutoCommit(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public static void main(String[] args) {
        RoomDBContext rdbc = new RoomDBContext();
        OrderDBContext odbc = new OrderDBContext();
        Order order = odbc.getOrderByID(3);
        order = rdbc.getRoomsByOrderID(order);
        for (Room room : order.getRooms()) {
            System.out.println(room.getName());
        }
    }
}
