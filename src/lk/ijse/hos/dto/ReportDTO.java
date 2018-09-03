/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.dto;

import java.util.Date;

/**
 *
 * @author slash
 */
public class ReportDTO {
       private String Report_ID;
    private String Appointment_ID;
    private String Patient_ID;
    private Date Date;
    private String Details;
    private String Treatments;

    public ReportDTO() {
    }

    public ReportDTO(String Report_ID, String Appointment_ID, String Patient_ID, Date Date, String Details, String Treatments) {
        this.Report_ID = Report_ID;
        this.Appointment_ID = Appointment_ID;
        this.Patient_ID = Patient_ID;
        this.Date = Date;
        this.Details = Details;
        this.Treatments = Treatments;
    }

    @Override
    public String toString() {
        return "ReportDTO{" + "Report_ID=" + getReport_ID() + ", Appointment_ID=" + getAppointment_ID() + ", Patient_ID=" + getPatient_ID() + ", Date=" + getDate() + ", Details=" + getDetails() + ", Treatments=" + getTreatments() + '}';
    }

    /**
     * @return the Report_ID
     */
    public String getReport_ID() {
        return Report_ID;
    }

    /**
     * @param Report_ID the Report_ID to set
     */
    public void setReport_ID(String Report_ID) {
        this.Report_ID = Report_ID;
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

    /**
     * @return the Details
     */
    public String getDetails() {
        return Details;
    }

    /**
     * @param Details the Details to set
     */
    public void setDetails(String Details) {
        this.Details = Details;
    }

    /**
     * @return the Treatments
     */
    public String getTreatments() {
        return Treatments;
    }

    /**
     * @param Treatments the Treatments to set
     */
    public void setTreatments(String Treatments) {
        this.Treatments = Treatments;
    }

}
