/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import panetfood.pojos.ProductsPojo;
import planetfood.utility.DBConnection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rajshekhar sahu
 */
public class ProductsDao {
    
    public static String getNewId() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select count(*) from products");
        ResultSet rs = prmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return "P" + (count + 101);
    }
    
    public static boolean addProduct(ProductsPojo pj) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("insert into products values(?, ?, ?, ?, ?)");
        prmt.setString(1, pj.getProdId());
        prmt.setString(2, pj.getProdName());
        prmt.setString(3, pj.getCatId());
        prmt.setDouble(4, pj.getProdPrice());
        prmt.setString(5, pj.getIsActive());
        return prmt.executeUpdate() > 0;
    }
    
    public static boolean editProduct(ProductsPojo pj) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("update products set prod_name = ?, cat_id = ?, prod_price = ?, active = ? where prod_id = ?");
        prmt.setString(5, pj.getProdId());
        prmt.setString(1, pj.getProdName());
        prmt.setString(2, pj.getCatId());
        prmt.setDouble(3, pj.getProdPrice());
        prmt.setString(4, pj.getIsActive());
        return prmt.executeUpdate() > 0;
    }
    
    public static boolean removeProduct(String prodId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("update products set active = 'N' where prod_id = ?");
        prmt.setString(1, prodId);
        return prmt.executeUpdate() > 0;
    }
    
    public static ArrayList<ProductsPojo> viewAllProducts() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from products");
        ResultSet rs = prmt.executeQuery();
        ArrayList<ProductsPojo> al = new ArrayList<ProductsPojo>();
        while (rs.next()) {
            ProductsPojo pp = new ProductsPojo();
            pp.setProdId(rs.getString("prod_id"));
            pp.setProdName(rs.getString("prod_name"));
            pp.setCatId(rs.getString("cat_id"));
            pp.setProdPrice(rs.getDouble("prod_price"));
            pp.setIsActive(rs.getString("active"));
            al.add(pp);
        }
        return al;
    }
    
    public static HashMap<String, ProductsPojo> getAllProducts() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from products");
        ResultSet rs = prmt.executeQuery();
        HashMap<String, ProductsPojo> al = new HashMap<String, ProductsPojo>();
        while (rs.next()) {
            ProductsPojo pp = new ProductsPojo();
            pp.setProdId(rs.getString("prod_id"));
            pp.setProdName(rs.getString("prod_name"));
            pp.setCatId(rs.getString("cat_id"));
            pp.setProdPrice(rs.getDouble("prod_price"));
            pp.setIsActive(rs.getString("active"));
            al.put(pp.getProdId(), pp);
        }
        return al;
    }
    
    public static HashMap<String, ProductsPojo> getProductsByCategory(String catId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from products where cat_id = ?");
        prmt.setString(1, catId);
        ResultSet rs = prmt.executeQuery();
        HashMap<String, ProductsPojo> al = new HashMap<String, ProductsPojo>();
        while (rs.next()) {
            ProductsPojo pp = new ProductsPojo();
            pp.setProdId(rs.getString("prod_id"));
            pp.setProdName(rs.getString("prod_name"));
            pp.setCatId(rs.getString("cat_id"));
            pp.setProdPrice(rs.getDouble("prod_price"));
            pp.setIsActive(rs.getString("active"));
            al.put(pp.getProdId(), pp);
        }
        return al;
    }
    
    public static ArrayList<ProductsPojo> getAllProductsByCategoryId(String catId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from products where cat_id = ? and active = 'Y'");
        prmt.setString(1, catId);
        ResultSet rs = prmt.executeQuery();
        ArrayList<ProductsPojo> al = new ArrayList<ProductsPojo>();
        while (rs.next()) {
            ProductsPojo pp = new ProductsPojo();
            pp.setProdId(rs.getString("prod_id"));
            pp.setProdName(rs.getString("prod_name"));
            pp.setCatId(rs.getString("cat_id"));
            pp.setProdPrice(rs.getDouble("prod_price"));
            pp.setIsActive(rs.getString("active"));
            al.add(pp);
        }
        return al;
    }
    
    public static ProductsPojo viewProduct(String prodId, String catId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select prod_name, prod_price from products where prod_id = ? and cat_id = ?");
        prmt.setString(1, prodId);
        prmt.setString(2, catId);
        ResultSet rs = prmt.executeQuery();
        ProductsPojo pp = null;
        if (rs.next()) {
            pp = new ProductsPojo();
            pp.setProdId(prodId);
            pp.setProdName(rs.getString("prod_name"));
            pp.setCatId(catId);
            pp.setProdPrice(rs.getDouble("prod_price"));
            
        }
        return pp;
    }
    
    public static HashMap<String, String> getAllProductsIdByCategory(String catId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select prod_id, prod_name from products where cat_id = ? and active = 'Y'");
        prmt.setString(1, catId);
        ResultSet rs = prmt.executeQuery();
        HashMap<String, String> al = new HashMap<String, String>();
        while (rs.next()) {
            al.put(rs.getString("prod_name"), rs.getString("prod_id"));
        }
        return al;
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(ProductsDao.getAllProductsByCategoryId("C101"));
    }
}
