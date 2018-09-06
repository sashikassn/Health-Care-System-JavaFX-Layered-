/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class MainFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgDoc;
    @FXML
    private ImageView imgPatient;
    @FXML
    private ImageView imgReport;
    @FXML
    private ImageView imgAppointment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void OnMouseClick(MouseEvent event) throws IOException {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;
            
            switch(icon.getId()){
                case "imgDoc":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/DoctorForm.fxml"));
                    break;
                case "imgPatient":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/PatientForm.fxml"));
                    break;
                case "imgReport":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/ReportForm.fxml"));
                    break;
                case "imgAppointment":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/AppointmentForm.fxml"));
                    break;
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(150), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
                
            }
            
        }
        
    }
    
}
