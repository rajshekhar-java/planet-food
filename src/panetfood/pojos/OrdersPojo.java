/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panetfood.pojos;

/**
 *
 * @author Rajshekhar sahu
 */
public class OrdersPojo {
    private String ordId;
    private String ordDate;
    private double gst;
    private double gstAmount;
    private double discount;
    private double ordAmount;
    private double grandTotal;
    private String userId;

    public OrdersPojo() {
    }

    public OrdersPojo(String ordId, String ordDate, double gst, double gstAmount, double discount, double ordAmount, double grandTotal, String userId) {
        this.ordId = ordId;
        this.ordDate = ordDate;
        this.gst = gst;
        this.gstAmount = gstAmount;
        this.discount = discount;
        this.ordAmount = ordAmount;
        this.grandTotal = grandTotal;
        this.userId = userId;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
