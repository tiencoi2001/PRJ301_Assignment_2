/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Vu Duc Tien
 */
public class UserDBContext extends DBContext {

    public User getUser(String username, String password) {
        try {
            String sql = "SELECT a.[AccountID],[Username],[Password],[Name],[DateOfBirth],[Email],[Phone],[Address], r.[RoleName]\n"
                    + "FROM [Users] u\n"
                    + "JOIN Accounts a ON a.AccountID = u.AccountID\n"
                    + "JOIN Account_Role ar on ar.AccountID = a.AccountID\n"
                    + "JOIN Roles r on r.RoleID = ar.RoleID\n"
                    + "WHERE Username = ? AND Password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("AccountID"));
                user.setUsername(username);
                user.setPassword(password);
                user.setName(rs.getString("name"));
                user.setDoB(rs.getDate("DateOfBirth"));
                user.setEmail(rs.getString("Email"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("RoleName"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDBContext udbc = new UserDBContext();
        User u = udbc.getUser("0983563147", "123456");
        System.out.println(u.toString());

    }
}
