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
public class PatientTM {
      private String Patient_ID;
    private String Patient_NAME;
    private int Patient_AGE;
    private String Patient_Gender;
    private String Patient_Address;

    public PatientTM() {
    }

    public PatientTM(String Patient_ID, String Patient_NAME, int Patient_AGE, String Patient_Gender, String Patient_Address) {
        this.Patient_ID = Patient_ID;
        this.Patient_NAME = Patient_NAME;
        this.Patient_AGE = Patient_AGE;
        this.Patient_Gender = Patient_Gender;
        this.Patient_Address = Patient_Address;
    }

    /**
     * @return the Patient_ID
     */
    public String getPatient_ID() {
        return Patient_ID;
    }

    /**
     * @param Patient_ID the Patient_ID to set
     */
    public void setPatient_ID(String Patient_ID) {
        this.Patient_ID = Patient_ID;
    }

    /**
     * @return the Patient_NAME
     */
    public String getPatient_NAME() {
        return Patient_NAME;
    }

    /**
     * @param Patient_NAME the Patient_NAME to set
     */
    public void setPatient_NAME(String Patient_NAME) {
        this.Patient_NAME = Patient_NAME;
    }

    /**
     * @return the Patient_AGE
     */
    public int getPatient_AGE() {
        return Patient_AGE;
    }

    /**
     * @param Patient_AGE the Patient_AGE to set
     */
    public void setPatient_AGE(int Patient_AGE) {
        this.Patient_AGE = Patient_AGE;
    }

    /**
     * @return the Patient_Gender
     */
    public String getPatient_Gender() {
        return Patient_Gender;
    }

    /**
     * @param Patient_Gender the Patient_Gender to set
     */
    public void setPatient_Gender(String Patient_Gender) {
        this.Patient_Gender = Patient_Gender;
    }

    /**
     * @return the Patient_Address
     */
    public String getPatient_Address() {
        return Patient_Address;
    }

    /**
     * @param Patient_Address the Patient_Address to set
     */
    public void setPatient_Address(String Patient_Address) {
        this.Patient_Address = Patient_Address;
    }

    @Override
    public String toString() {
        return "PatientTM{" + "Patient_ID=" + Patient_ID + ", Patient_NAME=" + Patient_NAME + ", Patient_AGE=" + Patient_AGE + ", Patient_Gender=" + Patient_Gender + ", Patient_Address=" + Patient_Address + '}';
    }
    
    
}
