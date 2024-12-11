package com.magan_korhaz.private_hospital;// HospitalApp.java (szövegek angolról magyarra fordítása és új funkciók bővítése)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HospitalApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab servicesTab = new Tab("Szolgáltatások");
        Tab aboutUsTab = new Tab("Rólunk");
        Tab contactTab = new Tab("Kapcsolat");

        servicesTab.setContent(new Label("Ez egy magánkórház, amely a legjobb egészségügyi szolgáltatásokat nyújtja."));
        aboutUsTab.setContent(new Label("Mi egy képzeletbeli magánkórház vagyunk, amely elkötelezett a páciensek egészségéért."));
        contactTab.setContent(new Label("Lépjen kapcsolatba velünk: Telefonszám: +36 30 123 4567, Email: info@magan-korhaz.hu"));

        tabPane.getTabs().addAll(servicesTab, aboutUsTab, contactTab);

        ComboBox<String> specializationComboBox = new ComboBox<>();
        specializationComboBox.getItems().addAll("Kardiológia", "Neurológia", "Ortopédia", "Bőrgyógyászat", "Fogászat", "Onkológia", "Pszichológia");

        ListView<String> doctorListView = new ListView<>();
        Label doctorDetailsLabel = new Label();

        specializationComboBox.setOnAction(e -> {
            doctorListView.getItems().clear();
            doctorDetailsLabel.setText("");

            switch (specializationComboBox.getValue()) {
                case "Kardiológia":
                    doctorListView.getItems().addAll("Dr. Kovács Béla", "Dr. Nagy Anna");
                    break;
                case "Neurológia":
                    doctorListView.getItems().addAll("Dr. Tóth Márk", "Dr. Varga Petra");
                    break;
                case "Ortopédia":
                    doctorListView.getItems().addAll("Dr. Szabó László", "Dr. Kiss Júlia");
                    break;
                case "Bőrgyógyászat":
                    doctorListView.getItems().addAll("Dr. Németh Gábor", "Dr. Papp Emese");
                    break;
                case "Fogászat":
                    doctorListView.getItems().addAll("Dr. Horváth Tamás", "Dr. Molnár Éva");
                    break;
                case "Onkológia":
                    doctorListView.getItems().addAll("Dr. Balogh Dávid", "Dr. Farkas Katalin");
                    break;
                case "Pszichológia":
                    doctorListView.getItems().addAll("Dr. Lukács Zoltán", "Dr. Juhász Nóra");
                    break;
            }
        });

        doctorListView.setOnMouseClicked(e -> {
            String selectedDoctor = doctorListView.getSelectionModel().getSelectedItem();
            if (selectedDoctor != null) {
                doctorDetailsLabel.setText(selectedDoctor + " rövid bemutatkozása: Magasan képzett szakorvos, aki a legjobb ellátást nyújtja.");
            }
        });

        Button bookAppointmentButton = new Button("Időpontfoglalás");
        Label bookingStatusLabel = new Label();

        bookAppointmentButton.setOnAction(e -> {
            bookingStatusLabel.setText("Sikeres időpontfoglalás");
        });

        VBox layout = new VBox(10, specializationComboBox, doctorListView, doctorDetailsLabel, bookAppointmentButton, bookingStatusLabel);

        BorderPane root = new BorderPane();
        root.setLeft(tabPane);
        root.setCenter(layout);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Magánkórház Alkalmazás");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
