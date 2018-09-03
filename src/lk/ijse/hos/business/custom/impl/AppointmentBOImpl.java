/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.hos.business.custom.AppointmentBO;
import lk.ijse.hos.dao.DAOFactory;

import lk.ijse.hos.dao.custom.AppointmentDAO;
import lk.ijse.hos.dto.AppointmentDTO;
import lk.ijse.hos.entity.Appointment;

/**
 *
 * @author slash
 */
public class AppointmentBOImpl implements AppointmentBO {

    AppointmentDAO appointmentDAO = (AppointmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Appointment);

    @Override
    public boolean saveAppointment(AppointmentDTO appintment) throws Exception {

        Appointment appo = new Appointment(appintment.getAppointment_ID(), appintment.getDoctor_ID(), appintment.getPatient_ID(), appintment.getDate());
        return appointmentDAO.save(appo);

    }

    @Override
    public boolean updateAppointment(AppointmentDTO appintment) throws Exception {

        Appointment appointment = new Appointment(appintment.getAppointment_ID(), appintment.getDoctor_ID(), appintment.getPatient_ID(), appintment.getDate());
        return appointmentDAO.update(appointment);

    }

    @Override
    public boolean deleteAppointment(String id) throws Exception {

        return appointmentDAO.delete(id);

    }

    @Override
    public AppointmentDTO findByID(String id) throws Exception {

        Appointment appointment = appointmentDAO.findByID(id);
        AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppointment_ID(), appointment.getDoctor_ID(), appointment.getPatient_ID(), appointment.getDate());

        return appointmentDTO;

    }

    @Override
    public ArrayList<AppointmentDTO> getAllAppointments() throws Exception {

        ArrayList<AppointmentDTO> array = new ArrayList<>();
        ArrayList<Appointment> eAppointments = appointmentDAO.getAll();
        for (Appointment appointment : eAppointments) {
            AppointmentDTO appo = new AppointmentDTO(appointment.getAppointment_ID(), appointment.getDoctor_ID(), appointment.getPatient_ID(), appointment.getDate());

            array.add(appo);
        }
   return array;
        }
    

    }