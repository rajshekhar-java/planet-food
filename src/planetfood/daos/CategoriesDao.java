/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import panetfood.pojos.CategoryPojo;
import planetfood.utility.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author Rajshekhar sahu
 */
public class CategoriesDao {

    public static HashMap<String, String> getAllCategoryName() throws SQLException {
        HashMap<String, String> hs = new HashMap<String, String>();
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from categories");
        ResultSet rs = prmt.executeQuery();
        while (rs.next()) {
            hs.put(rs.getString("cat_name"), rs.getString("cat_id"));
        }
        return hs;
    }

    public static HashMap<String, String> getAllCategoryId() throws SQLException {
        HashMap<String, String> hs = new HashMap<String, String>();
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from categories");
        ResultSet rs = prmt.executeQuery();
        while (rs.next()) {
            hs.put(rs.getString("cat_id"), rs.getString("cat_name"));
        }
        return hs;
    }

    public static boolean addCategory(CategoryPojo c) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("insert into categories values(?, ?)");
        prmt.setString(1, c.getCatId());
        prmt.setString(2, c.getCatName());
        return prmt.executeUpdate() > 0;
    }

    public static boolean updateCategory(CategoryPojo c) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("update categories set cat_name = ? where cat_id = ?");
        prmt.setString(2, c.getCatId());
        prmt.setString(1, c.getCatName());
        return prmt.executeUpdate() > 0;
    }

    public static ArrayList<CategoryPojo> getAllCategory() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from categories");
        ResultSet rs = prmt.executeQuery();
        ArrayList<CategoryPojo> al = new ArrayList<CategoryPojo>();
        while (rs.next()) {
            CategoryPojo cp = new CategoryPojo();
            cp.setCatId(rs.getString("cat_id"));
            cp.setCatName(rs.getString("cat_name"));
            al.add(cp);
        }
        return al;
    }

    public static String getNewId() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select count(*) from categories");
        ResultSet rs = prmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return "C" + (count + 101);
    }
    
}
