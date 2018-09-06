/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author slash
 */
public class LoginFormController implements Initializable {

    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLoginBtnClick(ActionEvent event) throws IOException {
         if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")){
            
            Parent root = null;
            
            root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/MainForm.fxml"));
            
            if (root!=null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition t = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                t.setFromX(-subScene.getWidth());
                t.setToX(0);
                t.play();
            }
            
        }else{
            new Alert(Alert.AlertType.ERROR, "UserName Or Password Incorrect").show();
        }
    }

    @FXML
    private void onCancelBtnClick(ActionEvent event) {
        txtPassword.setText("");
        txtUsername.setText("");
        
    }
    
}
