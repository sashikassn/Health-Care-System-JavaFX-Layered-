/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.dao;

import lk.ijse.hos.dao.custom.impl.AppointmentDAOImpl;
import lk.ijse.hos.dao.custom.impl.DoctorDAOImpl;
import lk.ijse.hos.dao.custom.impl.PatientDAOImpl;
import lk.ijse.hos.dao.custom.impl.QueryDAOImpl;
import lk.ijse.hos.dao.custom.impl.ReportDAOImpl;
import lk.ijse.hos.entity.Appointment;
import lk.ijse.hos.entity.Doctor;
import lk.ijse.hos.entity.Patient;
import lk.ijse.hos.entity.Report;

/**
 *
 * @author slash
 */
public class DAOFactory {
    private static DAOFactory dAOFactory;
    
     private DAOFactory() {
    }
     public static DAOFactory getInstance(){
        if(dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
     public enum DAOType{
         Doctor,Patient,Appointment,Report
    }
     
         
    public SuperDAO getDAO(DAOType type ){
        switch(type){
            case Doctor:
                return new DoctorDAOImpl();
            case Patient:
                return new PatientDAOImpl();
            case Appointment:
                return new AppointmentDAOImpl();
            case Report:
                return new ReportDAOImpl();
          
            default:
                return null;
        }
    }
     
     
     
}
