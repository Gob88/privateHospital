

package com.magan_korhaz.private_hospital;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HospitalApp extends Application {

    private final Map<String, String[]> availableTimesBySpecialization = new HashMap<>() {{
        put("Kardiológia", new String[]{"9:00", "10:00", "11:00"});
        put("Neurológia", new String[]{"12:00", "13:00", "14:00"});
        put("Ortopédia", new String[]{"15:00", "16:00", "17:00"});
        put("Bőrgyógyászat", new String[]{"10:30", "11:30", "12:30"});
        put("Fogászat", new String[]{"8:00", "9:30", "10:30"});
        put("Onkológia", new String[]{"13:00", "14:30", "15:30"});
        put("Pszichológia", new String[]{"9:00", "10:30", "12:00"});
    }};

    @Override
    public void start(Stage primaryStage) {
        // Bejelentkezési képernyő
        Stage loginStage = new Stage();
        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setStyle("-fx-background-color: lightblue;");

        Label loginTitle = new Label("Bejelentkezés");
        loginTitle.setFont(new Font(20));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Felhasználónév");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Jelszó");

        Button loginButton = new Button("Bejelentkezés");
        Button registerButton = new Button("Regisztráció");
        HBox buttonsBox = new HBox(10, loginButton, registerButton);
        buttonsBox.setAlignment(Pos.CENTER);

        Label loginMessageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals("admin") && password.equals("admin")) {
                loginStage.close();
                showMainApplication(primaryStage);
            } else {
                loginMessageLabel.setText("Hibás felhasználónév vagy jelszó!");
            }
        });

        loginLayout.getChildren().addAll(loginTitle, usernameField, passwordField, buttonsBox, loginMessageLabel);
        Scene loginScene = new Scene(loginLayout, 400, 300);
        loginStage.setScene(loginScene);
        loginStage.setTitle("Bejelentkezés");
        loginStage.show();
    }

    private void showMainApplication(Stage primaryStage) {
        // Felső rész: Logó és kórház neve
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #f4f4f4;");

        ImageView logo = new ImageView(new Image(getClass().getResource("/logo.png").toExternalForm()));
        logo.setFitWidth(120);
        logo.setPreserveRatio(true);

        Label hospitalName = new Label("EgészségMagánKórház");
        hospitalName.setFont(new Font(32));
        hospitalName.setStyle("-fx-text-fill: #333;");

        header.getChildren().addAll(logo, hospitalName);

        // Bal oldali menü
        VBox menu = new VBox(10);
        menu.setPadding(new Insets(10));
        menu.setStyle("-fx-background-color: #e6e6e6;");
        menu.setPrefWidth(150);

        Button homeButton = new Button("Kezdőlap");
        Button aboutButton = new Button("Rólunk");
        Button servicesButton = new Button("Szolgáltatásaink");
        Button contactButton = new Button("Kapcsolat");
        menu.getChildren().addAll(homeButton, aboutButton, servicesButton, contactButton);

        // Középső rész: Szakterület és orvosok
        VBox centerContent = new VBox(10);
        centerContent.setPadding(new Insets(10));
        centerContent.setStyle("-fx-background-color: lightblue;");


        Label doctorLabel = new Label("Válasszon orvost:");
        ListView<String> doctorListView = new ListView<>();
        doctorListView.setPrefHeight(80);
        ImageView doctorImageView = new ImageView();
        doctorImageView.setFitWidth(150);
        doctorImageView.setPreserveRatio(true);
        Label doctorDetailsLabel = new Label();
        doctorDetailsLabel.setWrapText(true);
        doctorDetailsLabel.setStyle("-fx-background-color: white; -fx-padding: 10; -fx-border-color: gray; -fx-border-radius: 5;");



        doctorListView.setOnMouseClicked(e -> {
            String selectedDoctor = doctorListView.getSelectionModel().getSelectedItem();
            if (selectedDoctor != null) {
                switch (selectedDoctor) {
                    case "Dr. Kovács Béla":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_kovacs_bela.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Kovács Béla: Elismert kardiológus, több mint 500 sikeres beavatkozással.");
                        break;
                    case "Dr. Nagy Anna":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_nagy_anna.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Nagy Anna: Specialista a szívritmuszavar kezelésében.");
                        break;
                    case "Dr. Tóth Márk":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_toth_mark.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Tóth Márk: Neurológus, úttörő a Parkinson-kór kezelésében.");
                        break;
                    case "Dr. Varga Petra":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_varga_petra.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Varga Petra: Specialista az epilepszia modern kezelésében.");
                        break;
                    case "Dr. Szabó László":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_szabo_laszlo.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Szabó László: Ortopéd sebész, térdprotézis specialista.");
                        break;
                    case "Dr. Kiss Júlia":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_kiss_julia.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Kiss Júlia: Váll- és könyöksebészeti szakértő.");
                        break;
                    case "Dr. Németh Gábor":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_nemeth_gabor.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Németh Gábor: Dermatológus, a bőrrák specialistája.");
                        break;
                    case "Dr. Papp Emese":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_papp_emese.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Papp Emese: Bőrgyógyász, autoimmun betegségek szakértője.");
                        break;
                    case "Dr. Horváth Tamás":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_horvath_tamas.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Horváth Tamás: Fogorvos, implantátum specialista.");
                        break;
                    case "Dr. Molnár Éva":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_molnar_eva.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Molnár Éva: Esztétikai fogorvos, mosolytervezés szakértője.");
                        break;
                    case "Dr. Balogh Dávid":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_balogh_david.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Balogh Dávid: Onkológus, áttörő kezelések vezetője.");
                        break;
                    case "Dr. Farkas Katalin":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_farkas_katalin.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Farkas Katalin: Sugárterápiás szakértő.");
                        break;
                    case "Dr. Lukács Zoltán":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_lukacs_zoltan.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Lukács Zoltán: Pszichológus, stresszkezelés szakértője.");
                        break;
                    case "Dr. Juhász Nóra":
                        doctorImageView.setImage(new Image(getClass().getResource("/images/dr_juhasz_nora.png").toExternalForm()));
                        doctorDetailsLabel.setText("Dr. Juhász Nóra: Klinikai pszichológus, trauma szakértő.");
                        break;
                }
            }
        });




        // Jobb oldali rész: Naptár és időpontok
        VBox rightContent = new VBox(10);
        rightContent.setPadding(new Insets(10));
        rightContent.setStyle("-fx-background-color: lightblue;");

        Label calendarLabel = new Label("Válasszon dátumot:");
        DatePicker datePicker = new DatePicker();
        Label availableTimesLabel = new Label("Elérhető időpontok:");
        ListView<String> timesListView = new ListView<>();

        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date != null && (date.getDayOfWeek() == DayOfWeek.MONDAY || date.getDayOfWeek() == DayOfWeek.WEDNESDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY)) {
                    setTextFill(Color.RED);
                } else {
                    setDisable(true);
                    setTextFill(Color.GRAY);
                }
            }
        });


        Button bookAppointmentButton = new Button("Időpontfoglalás");
        Label bookingStatusLabel = new Label();

        bookAppointmentButton.setOnAction(e -> {
            if (datePicker.getValue() != null && !timesListView.getSelectionModel().isEmpty() && !timesListView.getSelectionModel().getSelectedItem().equals("Ezeken a napokon nincs rendelés")) {
                bookingStatusLabel.setText("Sikeres időpontfoglalás!");
            } else {
                bookingStatusLabel.setText("Kérjük, válasszon dátumot és időpontot!");
            }
        });

        rightContent.getChildren().addAll(calendarLabel, datePicker, availableTimesLabel, timesListView, bookAppointmentButton, bookingStatusLabel);

        // Fő elrendezés
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(header);
        mainLayout.setLeft(menu);
        mainLayout.setCenter(centerContent);
        mainLayout.setRight(rightContent);


        aboutButton.setOnAction(e -> {
            centerContent.getChildren().clear();
            Label aboutContent = new Label("Rólunk:\n\nMi egy elkötelezett magánkórház vagyunk, amely kiváló minőségű egészségügyi szolgáltatásokat nyújt.\n\nCélunk:\n- Teljes körű betegellátás\n- Innovatív diagnosztikai és kezelési technológiák\n- Barátságos és hozzáértő személyzet biztosítása.");
            aboutContent.setFont(new Font(14));
            aboutContent.setWrapText(true);
            aboutContent.setTextAlignment(TextAlignment.JUSTIFY);
            centerContent.getChildren().add(aboutContent);
        });

        servicesButton.setOnAction(e -> {
            centerContent.getChildren().clear();
            Label servicesContent = new Label("Szolgáltatásaink:\n\n- Részletes diagnosztikai vizsgálatok\n- Személyre szabott kezelési tervek\n- Preventív egészségügyi ellenőrzések\n- Rehabilitációs programok\n\nKüldetésünk, hogy a legjobb ellátást biztosítsuk minden páciensünk számára.");
            servicesContent.setFont(new Font(14));
            servicesContent.setWrapText(true);
            servicesContent.setTextAlignment(TextAlignment.JUSTIFY);
            centerContent.getChildren().add(servicesContent);
        });

        contactButton.setOnAction(e -> {
            centerContent.getChildren().clear();
            Label contactContent = new Label("Kapcsolat:\n\nTelefonszám: +36 30 123 4567\nEmail: info@magan-korhaz.hu\nCím: 1234 Budapest, Példa utca 10.\n\nVegye fel velünk a kapcsolatot, hogy időpontot foglaljon, vagy kérdéseire választ kapjon.");
            contactContent.setFont(new Font(14));
            contactContent.setWrapText(true);
            contactContent.setTextAlignment(TextAlignment.JUSTIFY);
            centerContent.getChildren().add(contactContent);
        });

        Scene scene = new Scene(mainLayout, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Magánkórház Alkalmazás");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
