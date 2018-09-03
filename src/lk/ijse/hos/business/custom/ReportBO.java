/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom;

import java.util.ArrayList;
import lk.ijse.hos.business.SuperBO;
import lk.ijse.hos.dto.ReportDTO;

/**
 *
 * @author slash
 */
public interface ReportBO extends SuperBO{
    public boolean saveReport(ReportDTO report)throws Exception;
    
    public boolean updateReport(ReportDTO report)throws Exception;
    
    public boolean  deleteReport(String id)throws Exception;
    
    public ReportDTO findByID(String id)throws Exception;
    
    public ArrayList<ReportDTO> getallReports()throws Exception;
}
