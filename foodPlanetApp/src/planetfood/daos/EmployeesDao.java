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
import panetfood.pojos.EmployeesPojo;
import planetfood.utility.DBConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.HashMap;

/**
 *
 * @author Rajshekhar sahu
 */
public class EmployeesDao {

    public static boolean addEmployee(EmployeesPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("insert into employees values(?, ?, ?, ?, ?)");
        prmt.setString(1, emp.getEmpId());
        prmt.setString(2, emp.getEmpName());
        prmt.setString(3, emp.getEmpJob());
        prmt.setDouble(4, emp.getEmpSal());
        prmt.setString(5, emp.getActive());
        return prmt.executeUpdate() > 0;
    }

    public static boolean updateEmployee(EmployeesPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("update  employees set emp_name = ?, emp_job = ?, emp_sal = ?, active = ? where emp_id = ?");
        prmt.setString(5, emp.getEmpId());
        prmt.setString(1, emp.getEmpName());
        prmt.setString(2, emp.getEmpJob());
        prmt.setString(4, emp.getActive());
        prmt.setDouble(3, emp.getEmpSal());
        return prmt.executeUpdate() > 0;
    }

    public static boolean removeEmployee(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("delete from employees where emp_id = ?");
        prmt.setString(1, empId);
        return prmt.execute();
    }

    public static EmployeesPojo searchEmployee(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement prmt = conn.prepareStatement("select * from employees where emp_id = ? and active = 'Y'");
        prmt.setString(1, empId);
        ResultSet rs = prmt.executeQuery();
        EmployeesPojo ej = null;
        if (rs.next()) {
            ej.setEmpId(rs.getString(1));
            ej.setEmpName(rs.getString(2));
            ej.setEmpJob(rs.getString(3));
            ej.setEmpSal(rs.getDouble(4));
        }
        return ej;
    }

    public static ArrayList<EmployeesPojo> viewAllEmployees() {
        ArrayList<EmployeesPojo> al = new ArrayList<EmployeesPojo>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement prmt = conn.prepareStatement("select * from employees where active = 'Y'");
            ResultSet rs = prmt.executeQuery();
            while (rs.next()) {
                EmployeesPojo ej = new EmployeesPojo();
                ej.setEmpId(rs.getString(1));
                ej.setEmpName(rs.getString(2));
                ej.setEmpJob(rs.getString(3));
                ej.setEmpSal(rs.getDouble(4));
                al.add(ej);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unable to load data", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return al;
    }

    public static ArrayList<String> getUnregisteredEmployeeId() {
        ArrayList<String> al = new ArrayList<String>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement prmt = conn.prepareStatement("select emp_id from employees  where active = 'Y' and emp_id not in (select emp_id from users  where active = 'Y')");
            ResultSet rs = prmt.executeQuery();
            while (rs.next()) {
                al.add(rs.getString("emp_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unable to load data", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return al;
    }

    public static HashMap<String, EmployeesPojo> getAllEmployees() {
        HashMap<String, EmployeesPojo> al = new HashMap<String, EmployeesPojo>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement prmt = conn.prepareStatement("select * from employees where active = 'Y'");
            ResultSet rs = prmt.executeQuery();
            while (rs.next()) {
                EmployeesPojo ej = new EmployeesPojo();
                ej.setEmpId(rs.getString(1));
                ej.setEmpName(rs.getString(2));
                ej.setEmpJob(rs.getString(3));
                ej.setEmpSal(rs.getDouble(4));
                al.put(ej.getEmpId(), ej);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unable to load data", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return al;
    }

    public static String getNewId() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select count(*) from employees");
        ResultSet rs = prmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return "E" + (count + 101);
    }
}
