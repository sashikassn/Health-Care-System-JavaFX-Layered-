/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.dto;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author slash
 */
public class AppointmentDTO {
        private String Appointment_ID;
    private String Doctor_ID;
    private String Patient_ID;
    private Date Date;

    public AppointmentDTO() {
    }

    public AppointmentDTO(String Appointment_ID, String Doctor_ID, String Patient_ID, Date Date) {
        this.Appointment_ID = Appointment_ID;
        this.Doctor_ID = Doctor_ID;
        this.Patient_ID = Patient_ID;
        this.Date = Date;
    }

 
    /**
     * @return the Appointment_ID
     */
    public String getAppointment_ID() {
        return Appointment_ID;
    }

    /**
     * @param Appointment_ID the Appointment_ID to set
     */
    public void setAppointment_ID(String Appointment_ID) {
        this.Appointment_ID = Appointment_ID;
    }

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
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" + "Appointment_ID=" + Appointment_ID + ", Doctor_ID=" + Doctor_ID + ", Patient_ID=" + Patient_ID + ", Date=" + Date + '}';
    }
    
    
}
