
package com.magan_korhaz.private_hospital;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    private ComboBox<String> specializationComboBox;

    @FXML
    private ComboBox<String> doctorComboBox;

    @FXML
    private Label doctorInfoLabel;

    @FXML
    private TableView<String> availableSlotsTable;

    public void handleBooking() {
        // Logic for booking appointment
        System.out.println("Booking Appointment");
    }
}
