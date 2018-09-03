/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom;

import java.util.ArrayList;
import lk.ijse.hos.business.SuperBO;
import lk.ijse.hos.dto.AppointmentDTO;

/**
 *
 * @author slash
 */
public interface AppointmentBO extends SuperBO{
    public boolean saveAppointment (AppointmentDTO appintment)throws Exception;
    
    public boolean updateAppointment(AppointmentDTO appintment)throws Exception;
    
    public boolean  deleteAppointment(String id)throws Exception;
    
    public AppointmentDTO findByID(String id)throws Exception;
    
    public ArrayList<AppointmentDTO> getAllAppointments()throws Exception;
    
}
