/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rajshekhar sahu
 */
public class DBConnection {
    private static Connection conn;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/planet_food?useSSL=false&allowPublicKeyRetrieval=true", "root", "rajsahu08");
            System.out.println("Connection opened");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Driver not registered", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Connection not done", "Error", JOptionPane.ERROR_MESSAGE);
            se.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void closeConnection() {
        try { 
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in closing connection", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
