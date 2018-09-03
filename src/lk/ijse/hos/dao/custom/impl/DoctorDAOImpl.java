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
import lk.ijse.hos.dao.custom.DoctorDAO;
import lk.ijse.hos.entity.Doctor;

/**
 *
 * @author slash
 */
public class DoctorDAOImpl implements DoctorDAO{
    


    @Override
    public Boolean save(Doctor entity) throws Exception {
          return CrudUtil.executeUpdate("Insert into Doctor values(?,?,?,?,?)", entity.getDoctor_ID(),entity.getDoctor_Name(),entity.getAddress(),entity.getSpecialized_IN(),entity.getSalary());
    }

    @Override
    public Boolean delete(String id) throws Exception {
         return CrudUtil.executeUpdate("Delete from Doctor where Doctor_ID = ?", id);
    }

    @Override
    public Boolean update(Doctor entity) throws Exception {
        return CrudUtil.executeUpdate("Update Doctor set Doctor_Name = ?, Address = ? , Specialized_IN = ? , Salary = ? where Doctor_ID = ?", entity.getDoctor_Name(),entity.getAddress(),entity.getSpecialized_IN(),entity.getSalary(),entity.getDoctor_ID());
        
        
    }

    @Override
    public ArrayList<Doctor> getAll() throws Exception {
               ArrayList<Doctor> doctors = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("Select * from Doctor");
        while (rs.next()) {
            Doctor doctor = new Doctor(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5));
            doctors.add(doctor);
        }
        return doctors;
        
    }

    @Override
    public Doctor findByID(String id) throws Exception {
        ResultSet rs = CrudUtil.executeQuery("select * from Doctor where Doctor_ID = ?", id);
        rs.next();
        Doctor doctor = new Doctor(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5));
        return doctor;
    }
    
    
}
