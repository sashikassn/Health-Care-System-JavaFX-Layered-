/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hos.main.StartUp;

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
    @FXML
    private Label txtDate;
    @FXML
    private Label txtappointDesc;
    @FXML
    private Button btnSignOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     formatedDate();
       
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
    
    
    private void formatedDate (){
  Date dNow = new Date();
  SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
  String reportDate = ft.format(dNow);
  
  txtDate.setText(reportDate);
  
    }

    @FXML
    private void MouseExitAnim(MouseEvent event) {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
           
        }
        
    }

    @FXML
    private void MouseEnterAnim(MouseEvent event) {
                if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
        
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.BLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
    }

    @FXML
    private void MouseExitAnimSpecial(MouseEvent event) {
              if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(100), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            txtappointDesc.setText("");
           
        }
    }

    @FXML
    private void MouseEnterAnimSpecial(MouseEvent event) {
                     if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
        
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.GOLD);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
        
        
        txtappointDesc.setText("Click Here to Manage Appointments");
    }

    @FXML
    private void onSignOutBtnClick(ActionEvent event) {
        StartUp.navigateToHome(root, (Stage)this.root.getScene().getWindow());
    }
    
}
