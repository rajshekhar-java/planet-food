/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panetfood.pojos;

import java.util.Objects;

/**
 *
 * @author Rajshekhar sahu
 */
public class OrderDetailsPojo {
    private String ordId;
    private String prodId;
    private int quantity;
    private double cost;

    public OrderDetailsPojo() {
    }

    public OrderDetailsPojo(String ordId, String prodId, int quantity, double cost) {
        this.ordId = ordId;
        this.prodId = prodId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "OrderDetailsPojo{" + "ordId=" + ordId + ", prodId=" + prodId + ", quantity=" + quantity + ", cost=" + cost + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ordId);
        hash = 53 * hash + Objects.hashCode(this.prodId);
        hash = 53 * hash + this.quantity;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetailsPojo other = (OrderDetailsPojo) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.ordId, other.ordId)) {
            return false;
        }
        if (!Objects.equals(this.prodId, other.prodId)) {
            return false;
        }
        return true;
    }
    
    
}
