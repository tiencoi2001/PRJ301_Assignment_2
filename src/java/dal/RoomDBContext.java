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
    
    public static void main(String[] args) {
        RoomDBContext rdbc = new RoomDBContext();
        ArrayList<RoomType> roomTypes = rdbc.getAllRoomType();
        for (RoomType roomType : roomTypes) {
            System.out.println(roomType.getId() + " " + roomType.getName() + " " + roomType.getPrice());
        }
    }
}
