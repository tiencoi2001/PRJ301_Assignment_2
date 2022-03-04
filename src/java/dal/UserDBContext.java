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
            String sql = "SELECT a.[AccountID],[Username],[Password],[Name],[DateOfBirth],[Email],[Phone],[Address], r.[RoleName] \n"
                    + "FROM [Users] u \n"
                    + "JOIN Accounts a ON a.AccountID = u.AccountID \n"
                    + "JOIN Roles r on r.RoleID = a.RoleID \n"
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
                user.setDob(rs.getDate("DateOfBirth"));
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

    public void insertUser(User user) {
        try {
            connection.setAutoCommit(false);
            String sql1 = "INSERT INTO [Accounts] ([Username],[Password],[RoleID])\n"
                    + "     VALUES (?,?,?)";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setString(1, user.getUsername());
            stm1.setString(2, user.getPassword());
            if (user.getRole().equals("admin")) {
                stm1.setInt(3, 1);
            } else if (user.getRole().equals("staff")) {
                stm1.setInt(3, 2);
            } else {
                stm1.setInt(3, 3);
            }
            stm1.executeUpdate();

            String sql2 = "INSERT INTO [Users] ([Name],[DateOfBirth],[Email],[Phone],[Address])\n"
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement stm2 = connection.prepareStatement(sql2);
            stm2.setString(1, user.getName());
            stm2.setDate(2, user.getDob());
            stm2.setString(3, user.getEmail());
            stm2.setString(4, user.getPhone());
            stm2.setString(5, user.getAddress());
            stm2.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isExistAccount(User user) {
        try {
            String sql = "select * from Accounts a\n"
                    + "join Users u on a.AccountID = u.AccountID\n"
                    + "where a.Username = ? or u.Email = ? or u.Phone = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getPhone());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkEmailAndPhone(User user) {
        try {
            String sql = "select * from Accounts a\n"
                    + "join Users u on a.AccountID = u.AccountID\n"
                    + "where u.Email = ? or u.Phone = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getEmail());
            stm.setString(2, user.getPhone());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateUser(User user) {
        try {
            connection.setAutoCommit(false);

            String sql1 = "UPDATE [Accounts]\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE AccountID = ?";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setString(1, user.getPassword());
            stm1.setInt(2, user.getId());
            stm1.executeUpdate();

            String sql2 = "UPDATE [Users]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[DateOfBirth] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Address] = ?\n"
                    + " WHERE AccountID = ?";
            PreparedStatement stm2 = connection.prepareStatement(sql2);
            stm2.setString(1, user.getName());
            stm2.setDate(2, user.getDob());
            stm2.setString(3, user.getEmail());
            stm2.setString(4, user.getPhone());
            stm2.setString(5, user.getAddress());
            stm2.setInt(6, user.getId());
            stm2.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        UserDBContext udbc = new UserDBContext();
        User u = udbc.getUser("0983563147", "123456");
        System.out.println(u.toString());
    }
}
