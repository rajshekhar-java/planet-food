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
public class CategoryPojo {
    private String catId;
    private String catName;

    public CategoryPojo() {
    }

    public CategoryPojo(String catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "CategoryPojo{" + "catId=" + catId + ", catName=" + catName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.catId);
        hash = 97 * hash + Objects.hashCode(this.catName);
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
        final CategoryPojo other = (CategoryPojo) obj;
        if (!Objects.equals(this.catId, other.catId)) {
            return false;
        }
        if (!Objects.equals(this.catName, other.catName)) {
            return false;
        }
        return true;
    }
    
    
}
