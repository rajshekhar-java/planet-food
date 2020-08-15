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
public class UsersPojo {

    private String userId;
    private String userName;
    private String empId;
    private String password;
    private String userType;
    private String active;

    public UsersPojo() {
    }

    public UsersPojo(String userId, String userName, String empId, String password, String userType, String active) {
        this.userId = userId;
        this.userName = userName;
        this.empId = empId;
        this.password = password;
        this.userType = userType;
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UsersPojo{" + "userId=" + userId + ", userName=" + userName + ", empId=" + empId + ", password=" + password + ", userType=" + userType + ", active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.userId);
        hash = 73 * hash + Objects.hashCode(this.userName);
        hash = 73 * hash + Objects.hashCode(this.empId);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 73 * hash + Objects.hashCode(this.userType);
        hash = 73 * hash + Objects.hashCode(this.active);
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
        final UsersPojo other = (UsersPojo) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.userType, other.userType)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }

   
    
}
