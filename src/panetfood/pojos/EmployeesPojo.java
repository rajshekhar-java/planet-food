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
public class EmployeesPojo {

    private String empId;
    private String empName;
    private String empJob;
    private double empSal;
    private String active;

    public EmployeesPojo() {
    }

    public EmployeesPojo(String empId, String empName, String empJob, double empSal, String active) {
        this.empId = empId;
        this.empName = empName;
        this.empJob = empJob;
        this.empSal = empSal;
        this.active = active;
    }

    public EmployeesPojo(String empName, String empJob, double empSal, String active) {
        this.empName = empName;
        this.empJob = empJob;
        this.empSal = empSal;
        this.active = active;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EmployeesPojo{" + "empId=" + empId + ", empName=" + empName + ", empJob=" + empJob + ", empSal=" + empSal + ", active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.empId);
        hash = 29 * hash + Objects.hashCode(this.empName);
        hash = 29 * hash + Objects.hashCode(this.empJob);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.empSal) ^ (Double.doubleToLongBits(this.empSal) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.active);
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
        final EmployeesPojo other = (EmployeesPojo) obj;
        if (Double.doubleToLongBits(this.empSal) != Double.doubleToLongBits(other.empSal)) {
            return false;
        }
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        if (!Objects.equals(this.empName, other.empName)) {
            return false;
        }
        if (!Objects.equals(this.empJob, other.empJob)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }

   

    
}
