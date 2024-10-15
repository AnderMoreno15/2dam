/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class executes the aplication and shows the view
 * @author Ander and Iñigo F
 * @version 1.0
 */
public class Application extends javafx.application.Application {
    
    /**
     * Shows the view
     * @param stage Stage where the view is going to be displayed
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserDataWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method where the application is launched
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
