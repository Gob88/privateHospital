package com.magan_korhaz.private_hospital;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Map;

public class MainController {

    @FXML
    private ComboBox<String> specializationComboBox;

    @FXML
    private ListView<String> doctorListView;

    @FXML
    private ImageView doctorImage;

    private Map<String, Map<String, String>> specializationDoctorMap;

    @FXML
    private void initialize() {
        // Initialize specialization and doctor map
        initializeSpecializationsAndDoctors();

        // Populate the specialization combo box
        specializationComboBox.getItems().addAll("Kardiológia", "Neurológia", "Ortopédia", "Bőrgyógyászat", "Fogászat", "Onkológia", "Pszichológia");

        // Add a listener to load doctors based on the selected specialization
        specializationComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadDoctorsForSpecialization(newValue);
            }
        });

        // Add a listener to display the doctor image based on the selected doctor
        doctorListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateDoctorImage(newValue);
            }
        });
    }

    private void initializeSpecializationsAndDoctors() {
        specializationDoctorMap = new HashMap<>();

        // Kardiológia
        Map<String, String> cardiologyDoctors = new HashMap<>();
        cardiologyDoctors.put("Dr. Kovács Béla", "dr_kovacs_bela.png");
        cardiologyDoctors.put("Dr. Nagy Anna", "dr_nagy_anna.png");
        specializationDoctorMap.put("Kardiológia", cardiologyDoctors);

        // Neurológia
        Map<String, String> neurologyDoctors = new HashMap<>();
        neurologyDoctors.put("Dr. Tóth Márk", "dr_toth_mark.png");
        neurologyDoctors.put("Dr. Varga Petra", "dr_varga_petra.png");
        specializationDoctorMap.put("Neurológia", neurologyDoctors);

        // Ortopédia
        Map<String, String> orthopedicsDoctors = new HashMap<>();
        orthopedicsDoctors.put("Dr. Szabó László", "dr_szabo_laszlo.png");
        orthopedicsDoctors.put("Dr. Kiss Júlia", "dr_kiss_julia.png");
        specializationDoctorMap.put("Ortopédia", orthopedicsDoctors);

        // Bőrgyógyászat
        Map<String, String> dermatologyDoctors = new HashMap<>();
        dermatologyDoctors.put("Dr. Németh Gábor", "dr_nemeth_gabor.png");
        dermatologyDoctors.put("Dr. Papp Emese", "dr_papp_emese.png");
        specializationDoctorMap.put("Bőrgyógyászat", dermatologyDoctors);

        // Fogászat
        Map<String, String> dentistryDoctors = new HashMap<>();
        dentistryDoctors.put("Dr. Horváth Tamás", "dr_horvath_tamas.png");
        dentistryDoctors.put("Dr. Molnár Éva", "dr_molnar_eva.png");
        specializationDoctorMap.put("Fogászat", dentistryDoctors);

        // Onkológia
        Map<String, String> oncologyDoctors = new HashMap<>();
        oncologyDoctors.put("Dr. Balogh Dávid", "dr_balogh_david.png");
        oncologyDoctors.put("Dr. Farkas Katalin", "dr_farkas_katalin.png");
        specializationDoctorMap.put("Onkológia", oncologyDoctors);

        // Pszichológia
        Map<String, String> psychologyDoctors = new HashMap<>();
        psychologyDoctors.put("Dr. Lukács Zoltán", "dr_lukacs_zoltan.png");
        psychologyDoctors.put("Dr. Juhász Nóra", "dr_juhasz_nora.png");
        specializationDoctorMap.put("Pszichológia", psychologyDoctors);
    }

    private void loadDoctorsForSpecialization(String specialization) {
        doctorListView.getItems().clear();
        Map<String, String> doctors = specializationDoctorMap.get(specialization);
        if (doctors != null) {
            doctorListView.getItems().addAll(doctors.keySet());
        }
    }

    private void updateDoctorImage(String doctorName) {
        for (Map<String, String> doctors : specializationDoctorMap.values()) {
            if (doctors.containsKey(doctorName)) {
                String imageName = doctors.get(doctorName);
                try {
                    Image doctorImageObj = new Image(getClass().getResourceAsStream("/images/" + imageName));
                    doctorImage.setImage(doctorImageObj);
                } catch (Exception e) {
                    System.err.println("Failed to load image: " + imageName);
                }
                break;
            }
        }
    }
}
