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
public class ProductsPojo {
    private String prodId;
    private String catId;
    private String prodName;
    private double prodPrice;
    private String isActive;

    public ProductsPojo() {
    }

    public ProductsPojo(String prodId, String catId, String prodName, double prodPrice, String isActive) {
        this.prodId = prodId;
        this.catId = catId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.isActive = isActive;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
}
