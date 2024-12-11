
package com.magan_korhaz.private_hospital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private ComboBox<String> doctorBox;

    @FXML
    private TableView<Appointment> appointmentTable;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    @FXML
    private TableColumn<Appointment, String> timeColumn;

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        doctorBox.getItems().addAll("Dr. Kovács Béla", "Dr. Nagy Anna", "Dr. Tóth István");
    }

    @FXML
    private void showServices() {
        loadView("services.fxml");
    }

    @FXML
    private void showAbout() {
        loadView("about.fxml");
    }

    @FXML
    private void showContact() {
        loadView("contact.fxml");
    }

    @FXML
    private void loadAppointments() {
        String selectedDoctor = doctorBox.getSelectionModel().getSelectedItem();
        if (selectedDoctor != null) {
            appointmentTable.getItems().clear();
            appointmentTable.getItems().addAll(generateRandomAppointments());
        }
    }

    private List<Appointment> generateRandomAppointments() {
        Random random = new Random();
        return IntStream.range(1, 6)
            .mapToObj(i -> new Appointment("2023-12-" + (random.nextInt(30) + 1), random.nextInt(12) + 8 + ":00"))
            .collect(Collectors.toList());
    }

    private void loadView(String fxmlFile) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/" + fxmlFile));
            mainPane.setCenter(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
