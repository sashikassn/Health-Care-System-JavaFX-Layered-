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
import lk.ijse.hos.dao.custom.ReportDAO;
import lk.ijse.hos.entity.Report;

/**
 *
 * @author slash
 */
public class ReportDAOImpl implements ReportDAO{

    
    
    @Override
    public Boolean save(Report entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Report values(?,?,?,?,?,?)", entity.getReport_ID(),entity.getAppointment_ID(),entity.getPatient_ID(),entity.getDate(),entity.getDetails(),entity.getTreatments());
        
    }

    @Override
    public Boolean delete(String id) throws Exception {
      return CrudUtil.executeUpdate("Delete from Report where Report_ID = ?", id);
    }

    @Override
    public Boolean update(Report entity) throws Exception {
       return CrudUtil.executeUpdate("Update Report set Appointment_ID = ?, Patient_ID = ? , Date = ? , Details = ?, Treatments = ? where Report_ID = ?", entity.getAppointment_ID(),entity.getPatient_ID(),entity.getDate(),entity.getDetails(),entity.getTreatments(),entity.getReport_ID());
    }

    @Override
    public ArrayList<Report> getAll() throws Exception {
                ArrayList<Report> reports = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("Select * from Report");
        while (rs.next()) {
            Report report = new Report(rs.getString(1),rs.getString(2), rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6));
            reports.add(report);
        }
        return reports;
        
    }

    @Override
    public Report findByID(String id) throws Exception {
           ResultSet rs = CrudUtil.executeQuery("select * from Report where Report_ID = ?", id);
        rs.next();
        Report report = new Report(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6));
        return report;
    }
    
}
