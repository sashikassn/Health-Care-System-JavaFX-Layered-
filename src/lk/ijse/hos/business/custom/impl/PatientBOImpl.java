/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.hos.business.custom.PatientBO;
import lk.ijse.hos.dao.DAOFactory;
import lk.ijse.hos.dao.custom.PatientDAO;
import lk.ijse.hos.dto.PatientDTO;
import lk.ijse.hos.entity.Patient;

/**
 *
 * @author slash
 */
public class PatientBOImpl implements PatientBO {

    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Patient);

    @Override
    public boolean savePatient(PatientDTO patient) throws Exception {

        Patient patientt = new Patient(patient.getPatient_ID(), patient.getPatient_NAME(), patient.getPatient_AGE(), patient.getPatient_Gender(), patient.getPatient_Address());
        return patientDAO.save(patientt);

    }

    @Override
    public boolean updatePatient(PatientDTO patient) throws Exception {
        Patient patient1 = new Patient(patient.getPatient_ID(), patient.getPatient_NAME(), patient.getPatient_AGE(), patient.getPatient_Gender(), patient.getPatient_Address());

        return patientDAO.update(patient1);

    }

    @Override
    public boolean deletePatient(String id) throws Exception {
        return patientDAO.delete(id);
    }

    @Override
    public PatientDTO findByID(String id) throws Exception {

        Patient patient = patientDAO.findByID(id);
        PatientDTO patientDTO = new PatientDTO(patient.getPatient_ID(), patient.getPatient_NAME(), patient.getPatient_AGE(), patient.getPatient_Gender(), patient.getPatient_Address());
        return patientDTO;

    }

    @Override
    public ArrayList<PatientDTO> getallpatients() throws Exception {

        ArrayList<PatientDTO> arrayList = new ArrayList<>();
        ArrayList<Patient> patients = patientDAO.getAll();

        for (Patient patient : patients) {
            PatientDTO patientDTO = new PatientDTO(patient.getPatient_ID(), patient.getPatient_NAME(), patient.getPatient_AGE(), patient.getPatient_Gender(), patient.getPatient_Address());

            arrayList.add(patientDTO);
        }
        return arrayList;

    }

}
