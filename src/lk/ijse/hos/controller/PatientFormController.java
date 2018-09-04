/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class PatientFormController implements Initializable {

    @FXML
    private JFXTextField txtpatientName;
    @FXML
    private JFXTextField txtpatientAge;
    @FXML
    private JFXTextField txtGender;
    @FXML
    private JFXTextField txtpatientID;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private ImageView navigateHome;
    @FXML
    private JFXButton btnNewPatient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void onHomeimgClick(MouseEvent event) {
    }

    @FXML
    private void OnSavebtnClick(ActionEvent event) {
    }

    @FXML
    private void OnCancelBtnClick(ActionEvent event) {
    }

    @FXML
    private void OnNewPatientBtnClick(ActionEvent event) {
    }
    
}
