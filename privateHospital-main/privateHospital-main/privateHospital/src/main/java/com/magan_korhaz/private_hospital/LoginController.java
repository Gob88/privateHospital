
package com.magan_korhaz.private_hospital;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    public void handleLogin() {
        // Logic for login
        System.out.println("Login: " + emailField.getText());
    }

    public void switchToRegister() {
        // Logic to switch to register scene
        System.out.println("Switching to Register Screen");
    }
}
