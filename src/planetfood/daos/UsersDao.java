/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import panetfood.pojos.UsersPojo;
import planetfood.utility.DBConnection;
import java.util.HashMap;

/**
 *
 * @author Rajshekhar sahu
 */
public class UsersDao {

    public static String getNewId() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select count(*) from users");
        ResultSet rs = prmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return "U" + (count + 101);
    }

    public static boolean addUser(UsersPojo us) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?)");
        prmt.setString(1, us.getUserId());
        prmt.setString(2, us.getUserName());
        prmt.setString(3, us.getEmpId());
        prmt.setString(4, us.getPassword());
        prmt.setString(5, us.getUserType());
        prmt.setString(6, us.getActive());
        return prmt.executeUpdate() > 0;
    }

    public static boolean updateUser(UsersPojo us) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("update users set user_name = ?, emp_id = ?, password = ?, user_type = ?, active = ? where user_id = ?");
        prmt.setString(6, us.getUserId());
        prmt.setString(1, us.getUserName());
        prmt.setString(2, us.getEmpId());
        prmt.setString(3, us.getPassword());
        prmt.setString(4, us.getUserType());
        prmt.setString(5, us.getActive());
        return prmt.executeUpdate() > 0;
    }

    public static boolean removeUser(String userId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("delete from users where user_id = ?");
        prmt.setString(1, userId);
        return prmt.execute();
    }

    public static UsersPojo searchUser(String userId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("select * from users where user_id = ? and active = 'Y'");
        prmt.setString(1, userId);
        ResultSet rs = prmt.executeQuery();
        if (rs.next()) {
            UsersPojo ej = new UsersPojo();
            ej.setUserId(rs.getString(1));
            ej.setUserName(rs.getString(2));
            ej.setEmpId(rs.getString(3));
            ej.setPassword(rs.getString(4));
            ej.setUserType(rs.getString(5));
            return ej;
        } else {
            return null;
        }
    }

    public static ArrayList<UsersPojo> viewAllUsers() {
        ArrayList<UsersPojo> al = new ArrayList<UsersPojo>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement prmt = conn.prepareStatement("select * from users and active = 'Y'");
            ResultSet rs = prmt.executeQuery();
            while (rs.next()) {
                UsersPojo ej = new UsersPojo();
                ej.setUserId(rs.getString(1));
                ej.setUserName(rs.getString(2));
                ej.setEmpId(rs.getString(3));
                ej.setPassword(rs.getString(4));
                ej.setUserType(rs.getString(5));
                al.add(ej);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unable to load data", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return al;
    }

    public static HashMap<String, UsersPojo> getAllUsers() {
        HashMap<String, UsersPojo> al = new HashMap<String, UsersPojo>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement prmt = conn.prepareStatement("select * from users where active = 'Y'");
            ResultSet rs = prmt.executeQuery();
            while (rs.next()) {
                UsersPojo ej = new UsersPojo();
                ej.setUserId(rs.getString(1));
                ej.setUserName(rs.getString(2));
                ej.setEmpId(rs.getString(3));
                ej.setPassword(rs.getString(4));
                ej.setUserType(rs.getString(5));
                al.put(ej.getUserId(), ej);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unable to load data", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return al;
    }

    public static String validateUser(UsersPojo up) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("select user_name from users where user_id = ? and password = ? and user_type = ? and active = 'Y'");
        prmt.setString(1, up.getUserId());
        prmt.setString(2, up.getPassword());
        prmt.setString(3, up.getUserType());
        ResultSet rs = prmt.executeQuery();
        if (rs.next()) {
            return rs.getString("user_name");
        }
        return null;
    }

}
