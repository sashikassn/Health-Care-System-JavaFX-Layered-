/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business;

import lk.ijse.hos.business.custom.AppointmentBO;
import lk.ijse.hos.business.custom.DoctorBO;
import lk.ijse.hos.business.custom.PatientBO;
import lk.ijse.hos.business.custom.ReportBO;
import lk.ijse.hos.business.custom.impl.AppointmentBOImpl;
import lk.ijse.hos.business.custom.impl.DoctorBOImpl;
import lk.ijse.hos.business.custom.impl.PatientBOImpl;
import lk.ijse.hos.business.custom.impl.ReportBOImpl;

/**
 *
 * @author slash
 */
public class BOFactory {
    private static BOFactory bOFactory;
    
    private BOFactory(){
               
    }
    public static BOFactory getInstace(){
         if(bOFactory == null){
            bOFactory = new BOFactory();
        }
        
        return bOFactory;
    }
    
    public enum BOType{
        DoctorBO,AppointmentBO,PatientBO,ReportBO
    }
    
    public SuperBO getBO(BOType boType){
        switch(boType){
            case DoctorBO :
                return new DoctorBOImpl();
            case AppointmentBO:
                return new AppointmentBOImpl();
            case PatientBO:
                return new PatientBOImpl();            
            case ReportBO:
                return new ReportBOImpl();             
            default:
                return null;
                
        }
}
}
