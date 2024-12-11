
package com.magan_korhaz.private_hospital;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class RegisterController {

    @FXML
    private TextField regEmailField;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    public void handleRegister() {
        // Logic for registration
        System.out.println("Register: " + regEmailField.getText());
    }

    public void switchToLogin() {
        // Logic to switch to login scene
        System.out.println("Switching to Login Screen");
    }
}
