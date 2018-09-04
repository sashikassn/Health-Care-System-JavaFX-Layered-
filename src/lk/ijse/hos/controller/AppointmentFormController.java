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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tblAppointments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        tblAppointments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Doctor_ID"));
        tblAppointments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        tblAppointments.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Date"));
        
    }    

    @FXML
    private void OnMakeAppoClick(ActionEvent event) {
        saveAppointments();
        loadAppointments();
    }

    @FXML
    private void OnBtnCancelClick(ActionEvent event) {
         txtAppoID.setText("");
           txtDocID.setText("");
           txtpatientID.setText("");
           txtDate.setText("");
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
       
            
            String Appointment_ID = txtAppoID.getText();
            String Doctor_ID = txtDocID.getText();
            String Patient_ID = txtpatientID.getText();
            LocalDate Date = DatePicker.getValue();
            
            Date date = new Date();
            
            try {
            
                date = new SimpleDateFormat("yyyy-MM-dd").parse(Date.toString());
                     
        } catch (Exception ex) {
             Logger.getLogger(AppointmentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
}
