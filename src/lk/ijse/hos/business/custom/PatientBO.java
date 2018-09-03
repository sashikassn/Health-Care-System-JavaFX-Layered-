/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom;

import java.util.ArrayList;
import lk.ijse.hos.business.SuperBO;
import lk.ijse.hos.dto.PatientDTO;

/**
 *
 * @author slash
 */
public interface PatientBO extends SuperBO{
       public boolean savePatient(PatientDTO patient)throws Exception;
    
    public boolean updatePatient(PatientDTO patient)throws Exception;
    
    public boolean  deletePatient(String id)throws Exception;
    
    public PatientDTO findByID(String id)throws Exception;
    
    public ArrayList<PatientDTO> getallpatients()throws Exception;
}
