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
import lk.ijse.hos.dao.custom.DoctorDAO;
import lk.ijse.hos.dao.custom.PatientDAO;
import lk.ijse.hos.entity.Patient;

/**
 *
 * @author slash
 */
public class PatientDAOImpl implements PatientDAO{
    


    @Override
    public Boolean save(Patient entity) throws Exception {
       return CrudUtil.executeUpdate("Insert into Patient values(?,?,?,?,?)", entity.getPatient_ID(),entity.getPatient_NAME(),entity.getPatient_AGE(),entity.getPatient_Gender(),entity.getPatient_Address());
    }

    @Override
    public Boolean delete(String id) throws Exception {
          return CrudUtil.executeUpdate("Delete from Patient where Patient_ID = ?", id);
    }

    @Override
    public Boolean update(Patient entity) throws Exception {
 return CrudUtil.executeUpdate("Update Patient set Patient_NAME = ?, Patient_AGE = ? , Patient_Gender = ? , Patient_Address = ? where Patient_ID = ?", entity.getPatient_NAME(),entity.getPatient_AGE(),entity.getPatient_Gender(),entity.getPatient_Address(),entity.getPatient_ID());
        
    }

    @Override
    public ArrayList<Patient> getAll() throws Exception {
               ArrayList<Patient> patients = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("Select * from Patient");
        while (rs.next()) {
            Patient patient = new Patient(rs.getString(1),rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5));
            patients.add(patient);
        }
        return patients;
        
    }

    @Override
    public Patient findByID(String id) throws Exception {
        
            ResultSet rs = CrudUtil.executeQuery("select * from Patient where Patient_ID = ?", id);
        rs.next();
        Patient patient = new Patient(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5));
        return patient;
    }
    }
    
