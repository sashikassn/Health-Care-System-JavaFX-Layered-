/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.hos.dao.CrudUtil;
import lk.ijse.hos.dao.DAOFactory;
import lk.ijse.hos.dao.custom.AppointmentDAO;
import lk.ijse.hos.entity.Appointment;

/**
 *
 * @author slash
 */
public class AppointmentDAOImpl implements AppointmentDAO{

    
    
    @Override
    public Boolean save(Appointment entity) throws Exception {
       return CrudUtil.executeUpdate("Insert into Appointment values(?,?,?,?)", entity.getAppointment_ID(),entity.getDoctor_ID(),entity.getPatient_ID(),entity.getDate());
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Appointment where Appointment_ID = ?", id);
    }

    @Override
    public Boolean update(Appointment entity) throws Exception {
       return CrudUtil.executeUpdate("Update Appointment set Doctor_ID = ?, Patient_ID = ?, Date = ? where Appointment_ID = ?", entity.getDoctor_ID(),entity.getPatient_ID(),entity.getDate(),entity.getAppointment_ID());
    }

    @Override
    public ArrayList<Appointment> getAll() throws Exception {
        ArrayList<Appointment> appointments = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("Select * from Appointment");
        while (rs.next()) {
            Appointment appointment = new Appointment(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4));
            appointments.add(appointment);
            
        }
        return appointments;
    }

    @Override
    public Appointment findByID(String id) throws Exception {
        
             ResultSet rs = CrudUtil.executeQuery("select * from Appointment where Appointment_ID = ?", id);
        rs.next();
        Appointment appointment = new Appointment(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4));
        return appointment;
    }
    }
    
