/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DataAccess.UserManagerFactory;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.User;

/**
 * @author AI - Ander and Iñigo
 * @version 1.1
 */
public class UserDataWindowController {

    /**
     * @param tfUsername Text field where the username is going to be shown
     * @param tfPassword Text field where the password is going to be shown
     * @param tfName Text field where the name is going to be shown
     * @param tfSurname Text field where the surname is going to be shown
     */
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    /**
     * What is going to happen when the button is clicked (in this case there is only 1 button)
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            User user = UserManagerFactory.getDataAccessible().getData();

            tfUsername.setText(user.getUsername());
            tfPassword.setText(user.getPassword());
            tfName.setText(user.getName());
            tfSurname.setText(user.getSurname());

        } catch (Exception e) {
            Logger.getLogger("UserDataWindowController").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK).showAndWait();
        }
    }
}
