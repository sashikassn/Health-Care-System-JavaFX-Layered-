/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hos.business.BOFactory;
import lk.ijse.hos.business.custom.AppointmentBO;
import lk.ijse.hos.dto.AppointmentDTO;
import lk.ijse.hos.view.util.tblmodel.AppointmentTM;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class AppointmentFormController implements Initializable {

    @FXML
    private JFXTextField txtAppoID;
    @FXML
    private JFXTextField txtDocID;
    @FXML
    private JFXTextField txtpatientID;
    private JFXTextField txtDate;
    @FXML
    private JFXButton btnMakeAppo;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private ImageView navigateHome;
    @FXML
    private TableView<AppointmentTM> tblAppointments;

    private AppointmentBO appointmentBO = (AppointmentBO)BOFactory.getInstace().getBO(BOFactory.BOType.AppointmentBO);
    @FXML
    private AnchorPane root;
    @FXML
    private JFXDatePicker DatePicker;
    
    private boolean decide = false;
    @FXML
    private JFXButton btnNewAppo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tblAppointments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        tblAppointments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Doctor_ID"));
        tblAppointments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        tblAppointments.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Date"));
        loadAppointments();
    }    

    @FXML
    private void OnMakeAppoClick(ActionEvent event) {
  if(decide == true && !(tblAppointments.getSelectionModel().getSelectedIndex()>=0) ){
            saveAppointments();
            loadAppointments();
        }else if(tblAppointments.getSelectionModel().getSelectedIndex()>=0 && decide ==false){
            updateAppointments();
            loadAppointments();
        }
        else{
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Item..", ButtonType.OK).show();
        }
    }

    @FXML
    private void OnBtnCancelClick(ActionEvent event) {
        decide= true;
       
         txtAppoID.setText("");
           txtDocID.setText("");
           txtpatientID.setText("");
           
           tblAppointments.getSelectionModel().clearSelection();
        
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
    
    
    private void loadAppointments(){
                try {
            ArrayList<AppointmentDTO> AllAppointments = appointmentBO.getAllAppointments();
            ArrayList<AppointmentTM> addAppointments = new ArrayList<>();
            for (AppointmentDTO Allappointnment : AllAppointments) {
                AppointmentTM appointment = new AppointmentTM(Allappointnment.getAppointment_ID(),Allappointnment.getDoctor_ID(), Allappointnment.getPatient_ID(),Allappointnment.getDate());
                addAppointments.add(appointment);
            }
            tblAppointments.setItems(FXCollections.observableArrayList(addAppointments));
            
        } catch (Exception ex) {
            Logger.getLogger(AppointmentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void saveAppointments(){
       
            try{
                
            
            String Appointment_ID = txtAppoID.getText();
            String Doctor_ID = txtDocID.getText();
            String Patient_ID = txtpatientID.getText();
        LocalDate localDate = DatePicker.getValue();
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
        } catch (ParseException ex) {
            Logger.getLogger(AppointmentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            AppointmentDTO appointmentDTO = new AppointmentDTO(Appointment_ID, Doctor_ID, Patient_ID, date);
            
            
            Boolean result = appointmentBO.saveAppointment(appointmentDTO);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Apointment Has been placed Successfully", ButtonType.OK).show();
                
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to Save the Appointment", ButtonType.OK).show();
                
            }
            }catch (Exception ex) {
            Logger.getLogger(AppointmentFormController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
            
    }
    
    private void updateAppointments(){
        AppointmentTM selectAppo = tblAppointments.getSelectionModel().getSelectedItem();
        String Appointment_ID = selectAppo.getAppointment_ID();
        String Doctor_ID = selectAppo.getDoctor_ID();
        String Patient_ID = selectAppo.getPatient_ID();
        Date Date = selectAppo.getDate();
        
        AppointmentDTO appointmentDTO = new AppointmentDTO(Appointment_ID, Doctor_ID, Patient_ID, Date);
        
        try {
            Boolean result = appointmentBO.updateAppointment(appointmentDTO);
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Appointment has been Updated successfully..", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Error on update Appointment...", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(AppointmentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @FXML
    private void OnNewAppoClick(ActionEvent event) {
            decide = true;
            txtAppoID.setText("");
           txtDocID.setText("");
           txtpatientID.setText("");
           DatePicker.setValue(null);
           tblAppointments.getSelectionModel().clearSelection();
    }

    @FXML
    private void onTableClick(MouseEvent event) {
          txtAppoID.setText(tblAppointments.getSelectionModel().getSelectedItem().getAppointment_ID());
            txtDocID.setText(tblAppointments.getSelectionModel().getSelectedItem().getDoctor_ID());
        txtpatientID.setText(tblAppointments.getSelectionModel().getSelectedItem().getPatient_ID());
          Date date = tblAppointments.getSelectionModel().getSelectedItem().getDate();
          LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
          
          DatePicker.setValue(localDate);
        
       
    }
}
