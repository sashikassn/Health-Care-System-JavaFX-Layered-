/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.hos.business.custom.ReportBO;
import lk.ijse.hos.dao.DAOFactory;
import lk.ijse.hos.dao.custom.ReportDAO;
import lk.ijse.hos.dto.ReportDTO;
import lk.ijse.hos.entity.Report;

/**
 *
 * @author slash
 */
public class ReportBOImpl implements ReportBO {

    ReportDAO reportDAO = (ReportDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Report);

    @Override
    public boolean saveReport(ReportDTO report) throws Exception {

        Report reports = new Report(report.getReport_ID(), report.getAppointment_ID(), report.getPatient_ID(), report.getDate(), report.getDetails(), report.getTreatments());

        return reportDAO.save(reports);

    }

    @Override
    public boolean updateReport(ReportDTO report) throws Exception {

        Report reportss = new Report(report.getReport_ID(), report.getAppointment_ID(), report.getAppointment_ID(), report.getDate(), report.getDetails(), report.getTreatments());

        return reportDAO.save(reportss);

    }

    @Override
    public boolean deleteReport(String id) throws Exception {
        
               return reportDAO.delete(id);
    }

    @Override
    public ReportDTO findByID(String id) throws Exception {
       
        Report reports = reportDAO.findByID(id);
        ReportDTO reportDTO = new ReportDTO(reports.getReport_ID(), reports.getAppointment_ID(), reports.getPatient_ID(), reports.getDate(), reports.getDetails(), reports.getTreatments());
        
        return reportDTO;
   
    }

    @Override
    public ArrayList<ReportDTO> getallReports() throws Exception {
        
        
       ArrayList<ReportDTO> arrayList = new ArrayList<>();
       ArrayList<Report> reports = reportDAO.getAll();
       for(Report report: reports){
           ReportDTO reportDTO = new ReportDTO(report.getReport_ID(), report.getAppointment_ID(), report.getPatient_ID(), report.getDate(), report.getDetails(), report.getTreatments());
           arrayList.add(reportDTO);
           
                   
       }
        
      return arrayList;
    }
       
      
}
