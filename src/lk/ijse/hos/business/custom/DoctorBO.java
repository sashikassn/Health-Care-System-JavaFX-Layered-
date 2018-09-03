/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.business.custom;

import java.util.ArrayList;
import lk.ijse.hos.business.SuperBO;
import lk.ijse.hos.dto.DoctorDTO;

/**
 *
 * @author slash
 */
public interface DoctorBO extends SuperBO{
        public boolean saveDoctor(DoctorDTO doctor)throws Exception;
    
    public boolean updateDoctor(DoctorDTO doctor)throws Exception;
    
    public boolean  deleteDoctor(String id)throws Exception;
    
    public DoctorDTO findByID(String id)throws Exception;
    
    public ArrayList<DoctorDTO> getAllDoctors()throws Exception;
}
