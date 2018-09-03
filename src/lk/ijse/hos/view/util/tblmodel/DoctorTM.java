/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.view.util.tblmodel;

/**
 *
 * @author slash
 */
public class DoctorTM {
    private String Doctor_ID;
    private String Doctor_Name;
    private String Address;
    private String Specialized_IN;
    private Double Salary;

    /**
     * @return the Doctor_ID
     */
    public String getDoctor_ID() {
        return Doctor_ID;
    }

    /**
     * @param Doctor_ID the Doctor_ID to set
     */
    public void setDoctor_ID(String Doctor_ID) {
        this.Doctor_ID = Doctor_ID;
    }

    /**
     * @return the Doctor_Name
     */
    public String getDoctor_Name() {
        return Doctor_Name;
    }

    /**
     * @param Doctor_Name the Doctor_Name to set
     */
    public void setDoctor_Name(String Doctor_Name) {
        this.Doctor_Name = Doctor_Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Specialized_IN
     */
    public String getSpecialized_IN() {
        return Specialized_IN;
    }

    /**
     * @param Specialized_IN the Specialized_IN to set
     */
    public void setSpecialized_IN(String Specialized_IN) {
        this.Specialized_IN = Specialized_IN;
    }

    /**
     * @return the Salary
     */
    public Double getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public DoctorTM() {
    }

    public DoctorTM(String Doctor_ID, String Doctor_Name, String Address, String Specialized_IN, Double Salary) {
        this.Doctor_ID = Doctor_ID;
        this.Doctor_Name = Doctor_Name;
        this.Address = Address;
        this.Specialized_IN = Specialized_IN;
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "DoctorTM{" + "Doctor_ID=" + Doctor_ID + ", Doctor_Name=" + Doctor_Name + ", Address=" + Address + ", Specialized_IN=" + Specialized_IN + ", Salary=" + Salary + '}';
    }
    
    
    
    
}
