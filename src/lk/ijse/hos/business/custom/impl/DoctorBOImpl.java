/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.hos.business.custom.DoctorBO;
import lk.ijse.hos.dao.DAOFactory;
import lk.ijse.hos.dao.custom.DoctorDAO;
import lk.ijse.hos.dto.DoctorDTO;
import lk.ijse.hos.entity.Doctor;

/**
 *
 * @author slash
 */
public class DoctorBOImpl implements DoctorBO {

    DoctorDAO doctorDAO = (DoctorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Doctor);

    @Override
    public boolean saveDoctor(DoctorDTO doctor) throws Exception {

        Doctor doc = new Doctor(doctor.getDoctor_ID(), doctor.getDoctor_Name(), doctor.getAddress(), doctor.getSpecialized_IN(), doctor.getSalary());
        return doctorDAO.save(doc);

//        Appointment appo = new Appointment(appintment.getAppointment_ID(), appintment.getDoctor_ID(), appintment.getPatient_ID(), appintment.getDate());
//        return appointmentDAO.save(appo);
    }

    @Override
    public boolean updateDoctor(DoctorDTO doctor) throws Exception {
        Doctor doc = new Doctor(doctor.getDoctor_ID(), doctor.getDoctor_Name(), doctor.getAddress(), doctor.getSpecialized_IN(), doctor.getSalary());
        return doctorDAO.update(doc);

    }

    @Override
    public boolean deleteDoctor(String id) throws Exception {
        return doctorDAO.delete(id);

    }

    @Override
    public DoctorDTO findByID(String id) throws Exception {

        Doctor doctor = doctorDAO.findByID(id);
        DoctorDTO doctorDTO = new DoctorDTO(doctor.getDoctor_ID(), doctor.getDoctor_Name(), doctor.getAddress(), doctor.getSpecialized_IN(), doctor.getSalary());

        return doctorDTO;

    }

    @Override
    public ArrayList<DoctorDTO> getAllDoctors() throws Exception {

        ArrayList<DoctorDTO> arrayList = new ArrayList<>();
        ArrayList<Doctor> doctors = doctorDAO.getAll();
        for (Doctor doctor : doctors) {
            DoctorDTO doctorDTO = new DoctorDTO(doctor.getDoctor_ID(), doctor.getDoctor_Name(), doctor.getAddress(), doctor.getSpecialized_IN(), doctor.getSalary());

            arrayList.add(doctorDTO);
        }
        return arrayList;

    }

}
