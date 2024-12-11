package com.magan_korhaz.private_hospital;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HospitalApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hospital Management System");

        // Login Screen
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));

        Label loginLabel = new Label("Login");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button switchToRegisterButton = new Button("Register");

        loginLayout.getChildren().addAll(loginLabel, emailField, passwordField, loginButton, switchToRegisterButton);

        // Registration Screen
        VBox registerLayout = new VBox(10);
        registerLayout.setPadding(new Insets(20));

        Label registerLabel = new Label("Register");
        TextField regEmailField = new TextField();
        regEmailField.setPromptText("Email");
        PasswordField regPasswordField = new PasswordField();
        regPasswordField.setPromptText("Password");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        Button registerButton = new Button("Register");
        Button switchToLoginButton = new Button("Back to Login");

        registerLayout.getChildren().addAll(registerLabel, regEmailField, regPasswordField, confirmPasswordField, registerButton, switchToLoginButton);

        // Main Screen
        BorderPane mainLayout = new BorderPane();

        // Left Navigation Pane
        VBox navBar = new VBox(10);
        navBar.setPadding(new Insets(10));
        Button servicesButton = new Button("Services");
        Button aboutButton = new Button("About Us");
        Button contactButton = new Button("Contact");
        navBar.getChildren().addAll(servicesButton, aboutButton, contactButton);

        // Center Content
        VBox centerContent = new VBox(10);
        centerContent.setPadding(new Insets(20));
        Label selectSpecializationLabel = new Label("Select Specialization:");
        ComboBox<String> specializationComboBox = new ComboBox<>();
        specializationComboBox.getItems().addAll("Cardiology", "Neurology", "Orthopedics");

        Label selectDoctorLabel = new Label("Select Doctor:");
        ComboBox<String> doctorComboBox = new ComboBox<>();
        doctorComboBox.getItems().addAll("Dr. Smith", "Dr. Johnson", "Dr. Brown");

        Label doctorInfoLabel = new Label("Doctor Information: Please select a doctor.");
        TableView<String> availableSlotsTable = new TableView<>();
        Button bookAppointmentButton = new Button("Book Appointment");

        centerContent.getChildren().addAll(selectSpecializationLabel, specializationComboBox, selectDoctorLabel, doctorComboBox, doctorInfoLabel, availableSlotsTable, bookAppointmentButton);

        // Setting Layouts
        mainLayout.setLeft(navBar);
        mainLayout.setCenter(centerContent);

        // Scenes
        Scene loginScene = new Scene(loginLayout, 300, 200);
        Scene registerScene = new Scene(registerLayout, 300, 250);
        Scene mainScene = new Scene(mainLayout, 600, 400);

        // Switch Scenes
        switchToRegisterButton.setOnAction(e -> primaryStage.setScene(registerScene));
        switchToLoginButton.setOnAction(e -> primaryStage.setScene(loginScene));
        loginButton.setOnAction(e -> primaryStage.setScene(mainScene)); // Simulate successful login
        registerButton.setOnAction(e -> primaryStage.setScene(loginScene)); // Simulate successful registration

        // Initial Scene
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
