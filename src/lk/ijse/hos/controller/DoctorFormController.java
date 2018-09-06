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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hos.business.BOFactory;
import lk.ijse.hos.business.custom.DoctorBO;
import lk.ijse.hos.dto.DoctorDTO;
import lk.ijse.hos.view.util.tblmodel.DoctorTM;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class DoctorFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton BtnNewDoc;
    @FXML
    private JFXTextField txtDocName;
    @FXML
    private JFXTextField txtDocAddress;
    @FXML
    private JFXTextField txtDocSpecial;
    @FXML
    private JFXTextField txtDocSalary;
    @FXML
    private JFXTextField txtDocid;

 private boolean decide = false;
 
 private DoctorBO doctorBO = (DoctorBO)BOFactory.getInstace().getBO(BOFactory.BOType.DoctorBO);
 
    @FXML
    private JFXButton btnSave;
    @FXML
    private TableView<DoctorTM> tblDocas;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private ImageView navigateHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        tblDocas.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Doctor_ID"));
        tblDocas.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Doctor_Name"));
        tblDocas.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblDocas.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Specialized_IN"));
        tblDocas.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Salary"));
        loadAllDoctors();
        
    }    

    private void GotoHome(MouseEvent event) throws IOException {
                  if (event.getSource() instanceof ImageView) {
            ImageView img = (ImageView) event.getSource();
            Parent root = null;
            switch (img.getId()) {
                case "imgHome":
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
    private void NewDocbtnClick(ActionEvent event) {
        decide = true;
        txtDocid.setText("");
        txtDocName.setText("");
        txtDocAddress.setText("");
        txtDocSpecial.setText("");
        txtDocSalary.setText("");
        
        
    }

    @FXML
    private void BtnSaveOnAction(ActionEvent event) {
        if(decide){
            saveDoctor();
            loadAllDoctors();
            
        }else if (tblDocas.getSelectionModel().getSelectedIndex()>=0 && decide == false) {
            updateDoctors();
            loadAllDoctors();
            
        }
        else{
            new Alert(Alert.AlertType.WARNING, "Please Press The Add new Doctor* Button to add a Doctor", ButtonType.OK).show();
        }   
    }

    
    
    
    
    
    private void saveDoctor(){
        
        String Doctor_ID = txtDocid.getText();
        String Doctor_Name = txtDocName.getText();
        String Address = txtDocAddress.getText();
        String Specialized_IN = txtDocSpecial.getText();
        double Salary = new Double(txtDocSalary.getText());
        
        DoctorDTO doctorDTO = new DoctorDTO(Doctor_ID, Doctor_Name, Address, Specialized_IN, Salary);
      
        try{
            Boolean result = doctorBO.saveDoctor(doctorDTO);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Doctor Has been Saved Succfully.", ButtonType.OK).show();
                
            }else
                new Alert(Alert.AlertType.ERROR, "Failed to add the Doctor", ButtonType.OK).show();
          
        }catch (Exception ex){
            Logger.getLogger(DoctorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
private void loadAllDoctors(){
    try {
        ArrayList<DoctorDTO> Alldoctors = doctorBO.getAllDoctors();
        ArrayList<DoctorTM> AddDoctors = new ArrayList<>();
        
        for(DoctorDTO alldoctor : Alldoctors){
            DoctorTM doctor = new DoctorTM(alldoctor.getDoctor_ID(),alldoctor.getDoctor_Name(),alldoctor.getAddress(),alldoctor.getSpecialized_IN(),alldoctor.getSalary());
            AddDoctors.add(doctor);
            
        }
        tblDocas.setItems(FXCollections.observableArrayList(AddDoctors));
        
        
        
    } catch (Exception ex) {
         Logger.getLogger(DoctorFormController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void updateDoctors(){
    
    DoctorTM doctorTbl =  tblDocas.getSelectionModel().getSelectedItem();
    String Docid = doctorTbl.getDoctor_ID();
    String Docname = doctorTbl.getDoctor_Name();
    String DocAddress = doctorTbl.getAddress();
    String DocSpecial = doctorTbl.getSpecialized_IN();
    Double DocSalary = doctorTbl.getSalary();
    
    DoctorDTO doctorDTO = new DoctorDTO(Docid, Docname, DocAddress, DocSpecial, DocSalary);
    
    try {
        Boolean result = doctorBO.updateDoctor(doctorDTO);
        if(result){
            new Alert(Alert.AlertType.INFORMATION, "Doctor Details Updated Success", ButtonType.OK).show();
            
        }else{
            new Alert(Alert.AlertType.ERROR, "Doctor detail update failed", ButtonType.OK).show();
            
        }
        
    } catch (Exception ex) {
        Logger.getLogger(DoctorFormController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}
    


        private void deletecustomer(){
            DoctorTM doctor = tblDocas.getSelectionModel().getSelectedItem();
            String id = doctor.getDoctor_ID();
            
            
            try {
               Boolean result = doctorBO.deleteDoctor(id);
               if(result){
                   new Alert(Alert.AlertType.INFORMATION, "Doctor Has been Deleted Successfully", ButtonType.OK).show();
                   
               }else{
                   new Alert(Alert.AlertType.ERROR, "Doctor Delete Failed!", ButtonType.OK).show();
                   
               }
              
            } catch (Exception ex) {
                Logger.getLogger(DoctorFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    @FXML
    private void btnCancelOnAction(ActionEvent event) {
           decide = true;
        txtDocid.setText("");
        txtDocName.setText("");
        txtDocAddress.setText("");
        txtDocSpecial.setText("");
        txtDocSalary.setText("");
    
        
    }

    @FXML
    private void BtnDeleteOnAction(ActionEvent event) {
            if(tblDocas.getSelectionModel().getSelectedIndex()>=0){
            deletecustomer();
            loadAllDoctors();
            
        }else{
            new Alert(Alert.AlertType.ERROR, "Please Select a Doctor to Delete", ButtonType.OK).show();
        }
        
    }

    @FXML
    private void OnHomeImgClick(MouseEvent event) throws IOException {
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
                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }

        }
        
    }

    @FXML
    private void OnMouseClickAction(MouseEvent event) {
        txtDocid.setText(tblDocas.getSelectionModel().getSelectedItem().getDoctor_ID());
        txtDocName.setText(tblDocas.getSelectionModel().getSelectedItem().getDoctor_Name());
        txtDocAddress.setText(tblDocas.getSelectionModel().getSelectedItem().getAddress());
        txtDocSpecial.setText(tblDocas.getSelectionModel().getSelectedItem().getSpecialized_IN());
        txtDocSalary.setText(tblDocas.getSelectionModel().getSelectedItem().getSalary().toString());
        
        
    }
}