/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author slash
 */
public class StartUp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
         try {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hos/view/MainForm.fxml"));

            Scene mainScene = new Scene(root);

            primaryStage.setTitle("Hospital Management System -JAVAFX Version Ver1.2");
            primaryStage.setScene(mainScene);
            primaryStage.setResizable(false);
            
            primaryStage.show();
           

        } catch (IOException ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
