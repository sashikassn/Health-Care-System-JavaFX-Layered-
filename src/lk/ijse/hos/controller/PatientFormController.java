/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hos.business.BOFactory;
import lk.ijse.hos.business.custom.PatientBO;
import lk.ijse.hos.dto.PatientDTO;
import lk.ijse.hos.view.util.tblmodel.DoctorTM;
import lk.ijse.hos.view.util.tblmodel.PatientTM;

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
    @FXML
    private TableView<PatientTM> tblPatients;

    private boolean decide = false;

    /**
     * Initializes the controller class.
     */
    private PatientBO patientBO = (PatientBO) BOFactory.getInstace().getBO(BOFactory.BOType.PatientBO);

    private ArrayList<PatientTM> patietTbladd = new ArrayList<>();
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnDelete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblPatients.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        tblPatients.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Patient_NAME"));
        tblPatients.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Patient_AGE"));
        tblPatients.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Patient_Gender"));
        tblPatients.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Patient_Address"));
        loadAllpatients();

    }

    @FXML
    private void onHomeimgClick(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView img = (ImageView) event.getSource();
            Parent root = null;
            switch (img.getId()) {
                case "navigateHome":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/MainForm.fxml"));
                    break;

            }
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                primaryStage.show();
                TranslateTransition tt = new TranslateTransition(Duration.millis(150), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }

        }
    }

    @FXML
    private void OnSavebtnClick(ActionEvent event) {
        if (decide) {
            savePatients();
            loadAllpatients();

        } else if (tblPatients.getSelectionModel().getSelectedIndex() >= 0 && decide == false) {
            updatePatients();
            loadAllpatients();

        } else {
            new Alert(Alert.AlertType.WARNING, "Please Press The Add new Patient* Button to add a Patient", ButtonType.OK).show();
        }
    }

    @FXML
    private void OnCancelBtnClick(ActionEvent event) {
        decide = true;
        txtpatientID.setText("");
        txtpatientName.setText("");
        txtpatientAge.setText("");
        txtGender.setText("");
        txtAddress.setText("");
    }

    @FXML
    private void OnNewPatientBtnClick(ActionEvent event) {
        decide = true;
        txtpatientID.setText("");
        txtpatientName.setText("");
        txtpatientAge.setText("");
        txtGender.setText("");
        txtAddress.setText("");

    }

    private void loadAllpatients() {
        try {
            ArrayList<PatientDTO> AllPatients = patientBO.getallpatients();
            ArrayList<PatientTM> addPatients = new ArrayList<>();
            for (PatientDTO AllPatient : AllPatients) {
                PatientTM patient = new PatientTM(AllPatient.getPatient_ID(), AllPatient.getPatient_NAME(), AllPatient.getPatient_AGE(), AllPatient.getPatient_Gender(), AllPatient.getPatient_Address());
                addPatients.add(patient);
            }
            tblPatients.setItems(FXCollections.observableArrayList(addPatients));

        } catch (Exception ex) {
            Logger.getLogger(PatientFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void savePatients() {

        String Patient_ID = txtpatientID.getText();
        String Patient_NAME = txtpatientName.getText();
        int Patient_AGE = Integer.parseInt(txtpatientAge.getText());
        String Patient_Gender = txtGender.getText();
        String Patient_Address = txtAddress.getText();

        PatientDTO patientDTO = new PatientDTO(Patient_ID, Patient_NAME, Patient_AGE, Patient_Gender, Patient_Address);

        try {
            Boolean result = patientBO.savePatient(patientDTO);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Patient Has been Saved Successfully.", ButtonType.OK).show();

            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to add the Patient", ButtonType.OK).show();
            }

        } catch (Exception ex) {
            Logger.getLogger(PatientFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updatePatients() {
        PatientTM patienttbl = tblPatients.getSelectionModel().getSelectedItem();
        String Patient_ID = patienttbl.getPatient_ID();
        String Patient_NAME = patienttbl.getPatient_NAME();
        int Patient_AGE = patienttbl.getPatient_AGE();
        String Patient_Gender = patienttbl.getPatient_Gender();
        String Patient_Address = patienttbl.getPatient_Address();

        PatientDTO patientDTO = new PatientDTO(Patient_ID, Patient_NAME, Patient_AGE, Patient_Gender, Patient_Address);

        try {
            Boolean result = patientBO.updatePatient(patientDTO);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Patient Details Updated Success", ButtonType.OK).show();

            } else {
                new Alert(Alert.AlertType.ERROR, "Patient detail update failed", ButtonType.OK).show();

            }

        } catch (Exception ex) {
            Logger.getLogger(PatientFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onTblrawClick(MouseEvent event) {
        txtpatientID.setText(tblPatients.getSelectionModel().getSelectedItem().getPatient_ID());
        txtpatientName.setText(tblPatients.getSelectionModel().getSelectedItem().getPatient_NAME());
        int x = tblPatients.getSelectionModel().getSelectedItem().getPatient_AGE();
        txtpatientAge.setText(Integer.toString(x));
        txtGender.setText(tblPatients.getSelectionModel().getSelectedItem().getPatient_Gender());
        txtAddress.setText(tblPatients.getSelectionModel().getSelectedItem().getPatient_Address());

    }

    @FXML
    private void OnDeleteBtnClick(ActionEvent event) {
         if(tblPatients.getSelectionModel().getSelectedIndex()>=0){
            deletePatient();
            loadAllpatients();
            
        }else{
            new Alert(Alert.AlertType.ERROR, "Please Select a Patient to Delete", ButtonType.OK).show();
        }
        
        
    }

    
    
    private void deletePatient(){
        PatientTM patient = tblPatients.getSelectionModel().getSelectedItem();
            String id = patient.getPatient_ID();
            
            
            try {
               Boolean result = patientBO.deletePatient(id);
               if(result){
                   new Alert(Alert.AlertType.INFORMATION, "Patient Has been Deleted Successfully", ButtonType.OK).show();
                   
               }else{
                   new Alert(Alert.AlertType.ERROR, "patient Delete Failed!", ButtonType.OK).show();
                   
               }
              
            } catch (Exception ex) {
                Logger.getLogger(PatientFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
