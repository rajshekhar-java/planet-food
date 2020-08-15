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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import panetfood.pojos.OrderDetailsPojo;
import panetfood.pojos.OrdersPojo;
import planetfood.utility.DBConnection;
import java.util.HashMap;

/**
 *
 * @author Rajshekhar sahu
 */
public class OrdersDao {

    public static ArrayList<OrdersPojo> getOrdersByDate(Date startDate, Date endDate) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from orders where ord_date between ? and ?");
        long ms1 = startDate.getTime();
        long ms2 = endDate.getTime();
        java.sql.Date sDate = new java.sql.Date(ms1);
        java.sql.Date eDate = new java.sql.Date(ms2);
        prmt.setDate(1, sDate);
        prmt.setDate(2, eDate);
        ResultSet rs = prmt.executeQuery();
        ArrayList<OrdersPojo> al = new ArrayList<>();
        while (rs.next()) {
            OrdersPojo op = new OrdersPojo();
            op.setOrdId(rs.getString("ord_id"));
            java.sql.Date d = rs.getDate("ord_date");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            op.setOrdDate(sdf.format(d));
            op.setOrdAmount(rs.getDouble("ord_amount"));
            op.setGst(rs.getDouble("gst"));
            op.setGstAmount(rs.getDouble("gst_amount"));
            op.setGrandTotal(rs.getDouble("grand_total"));
            op.setDiscount(rs.getDouble("discount"));
            op.setUserId(rs.getString("user_id"));
            al.add(op);
        }
        return al;
    }
    
    public static ArrayList<OrdersPojo> getOrders() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from orders");
        ResultSet rs = prmt.executeQuery();
        ArrayList<OrdersPojo> al = new ArrayList<>();
        while (rs.next()) {
            OrdersPojo op = new OrdersPojo();
            op.setOrdId(rs.getString("ord_id"));
            java.sql.Date d = rs.getDate("ord_date");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            op.setOrdDate(sdf.format(d));
            op.setOrdAmount(rs.getDouble("ord_amount"));
            op.setGst(rs.getDouble("gst"));
            op.setGstAmount(rs.getDouble("gst_amount"));
            op.setGrandTotal(rs.getDouble("grand_total"));
            op.setDiscount(rs.getDouble("discount"));
            op.setUserId(rs.getString("user_id"));
            al.add(op);
        }
        return al;
    }
    
    public static ArrayList<OrdersPojo> getOrdersByUserId(String userId) throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select * from orders where user_id = ?");
        prmt.setString(1, userId);
        ResultSet rs = prmt.executeQuery();
        ArrayList<OrdersPojo> al = new ArrayList<>();
        while (rs.next()) {
            OrdersPojo op = new OrdersPojo();
            op.setOrdId(rs.getString("ord_id"));
            java.sql.Date d = rs.getDate("ord_date");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            op.setOrdDate(sdf.format(d));
            op.setOrdAmount(rs.getDouble("ord_amount"));
            op.setGst(rs.getDouble("gst"));
            op.setGstAmount(rs.getDouble("gst_amount"));
            op.setGrandTotal(rs.getDouble("grand_total"));
            op.setDiscount(rs.getDouble("discount"));
            op.setUserId(rs.getString("user_id"));
            al.add(op);
        }
        return al;
    }

    public static String getNewId() throws SQLException {
        PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select count(*) from orders");
        ResultSet rs = prmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return "OD" + (count + 101);
    }

    public static boolean addOrder(OrdersPojo order, ArrayList<OrderDetailsPojo> orderList) throws SQLException, ParseException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into orders values(?,?,?,?,?,?,?,?)");
        ps.setString(1, order.getOrdId());
        String dateStr = order.getOrdDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        java.util.Date d1 = sdf.parse(dateStr);
        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        ps.setDate(2, d2);
        ps.setDouble(4, order.getGst());
        ps.setDouble(5, order.getGstAmount());
        ps.setDouble(7, order.getDiscount());
        ps.setDouble(6, order.getGrandTotal());
        ps.setString(8, order.getUserId());
        ps.setDouble(3, order.getOrdAmount());
        int x = ps.executeUpdate();
        PreparedStatement ps2 = conn.prepareStatement("Insert into order_details values(?,?,?,?)");
        int count = 0, y;
        for (OrderDetailsPojo detail : orderList) {
            ps2.setString(1, detail.getOrdId());
            ps2.setString(2, detail.getProdId());
            ps2.setInt(3, detail.getQuantity());
            ps2.setDouble(4, detail.getCost());
            y = ps2.executeUpdate();
            count = count + y;
        }
        if (x > 0 && count == orderList.size()) {
            return true;
        } else {
            return false;
        }

    }
    
    public static HashMap<String, Integer> getTransection(Date startDate, Date endDate) throws SQLException {
         PreparedStatement prmt = DBConnection.getConnection().prepareStatement("select  prod_id , sum(quantity) as q from order_details left join orders on order_details.ord_id = orders.ord_id  where ord_date between ? and ?  group by prod_id");
        long ms1 = startDate.getTime();
        long ms2 = endDate.getTime();
        java.sql.Date sDate = new java.sql.Date(ms1);
        java.sql.Date eDate = new java.sql.Date(ms2);
        prmt.setDate(1, sDate);
        prmt.setDate(2, eDate);
        ResultSet rs = prmt.executeQuery();
        HashMap<String, Integer> tm = new HashMap<String, Integer>();
        HashMap<String, String> hm = ProductsDao.getAllProduct();
        while(rs.next()) {
            tm.put(hm.get(rs.getString("prod_id")), rs.getInt("q"));
        }
        return tm;
    }
    
    public static int getTotalSell(Date startDate, Date endDate) throws SQLException {
         PreparedStatement prmt = DBConnection.getConnection().prepareStatement("SELECT sum(grand_total) FROM planet_food.orders  where ord_date between ? and ?");
        long ms1 = startDate.getTime();
        long ms2 = endDate.getTime();
        java.sql.Date sDate = new java.sql.Date(ms1);
        java.sql.Date eDate = new java.sql.Date(ms2);
        prmt.setDate(1, sDate);
        prmt.setDate(2, eDate);
        ResultSet rs = prmt.executeQuery();
        int sum = 0;
        while(rs.next()) {
            sum = rs.getInt(1);
        }
        return sum;
    }
    
}
