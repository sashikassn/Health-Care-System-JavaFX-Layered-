/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import lk.ijse.hos.business.custom.ReportBO;
import lk.ijse.hos.dto.AppointmentDTO;
import lk.ijse.hos.dto.ReportDTO;
import lk.ijse.hos.view.util.tblmodel.AppointmentTM;
import lk.ijse.hos.view.util.tblmodel.ReportTM;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class ReportFormController implements Initializable {

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnNewReport;
    @FXML
    private JFXButton btnGenerateReport;
    @FXML
    private JFXButton btnDeleteReport;
    private JFXTextField txtAppointmentID;
    @FXML
    private JFXTextField txtPatientID;
    @FXML
    private JFXTextField txtReprtID;
    @FXML
    private JFXTextField txtDetails;
    @FXML
    private JFXTextField txtTreatments;
    @FXML
    private JFXDatePicker Datepicker;
    @FXML
    private ImageView navigateHome;
    @FXML
    private TableView<ReportTM> tblReports;
    
    ReportBO reportBO = (ReportBO)BOFactory.getInstace().getBO(BOFactory.BOType.ReportBO);
    @FXML
    private AnchorPane root;
    @FXML
    private JFXComboBox<?> cmbAppointmentID;

    /**
     * Initializes the controller class.
     */
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblReports.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Report_ID"));
        tblReports.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        tblReports.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        tblReports.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Date"));
        tblReports.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Details"));
        tblReports.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Treatments"));
    }    

    @FXML
    private void onSavebtnClick(ActionEvent event) {
        saveReports();
        loadReports();
        
    }

    @FXML
    private void onCancelBtnClick(ActionEvent event) {
        
    }

    @FXML
    private void onNewReportbtnClick(ActionEvent event) {
        
    }

    @FXML
    private void navigateHome(MouseEvent event) throws IOException {
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
    private void onGenerateReportbtnClick(ActionEvent event) {
    }

    @FXML
    private void onDeletebtnClick(ActionEvent event) {
    }
    
    
    
    private void saveReports(){
        try {
            String Report_ID = txtReprtID.getText();
            String Appointment_ID = txtAppointmentID.getText();
            String Patient_ID = txtPatientID.getText();
            LocalDate Date = Datepicker.getValue();
            
            Date date = new Date();
            
            try {
                
                date = new SimpleDateFormat("yyyy-MM-dd").parse(Date.toString());
                
            } catch (Exception ex) {
                Logger.getLogger(ReportFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String Details = txtDetails.getText();
            String Treatments = txtTreatments.getText();
            
            ReportDTO reportDTO = new ReportDTO(Report_ID, Appointment_ID, Patient_ID, date, Details, Treatments);
            
            
            Boolean result = reportBO.saveReport(reportDTO);
            
            if(result){
                new Alert(Alert.AlertType.INFORMATION, "Report Has been Recoreded Successfully", ButtonType.OK).show();
                
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to save the Report", ButtonType.OK).show();
                
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ReportFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadReports(){
         try {
            ArrayList<ReportDTO> AllReports = reportBO.getallReports();
            ArrayList<ReportTM> addReports = new ArrayList<>();
            for (ReportDTO AllReport : AllReports) {
                ReportTM report = new ReportTM(AllReport.getReport_ID(), AllReport.getAppointment_ID(), AllReport.getPatient_ID(), AllReport.getDate(), AllReport.getDetails(), AllReport.getTreatments());
                
                
            }
            tblReports.setItems(FXCollections.observableArrayList(addReports));
            
        } catch (Exception ex) {
            Logger.getLogger(ReportFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

               

       
    }
    
   
    

