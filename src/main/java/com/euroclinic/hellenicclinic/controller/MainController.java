package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import com.euroclinic.hellenicclinic.models.Appointment; // Fixed: Missing import!
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;

public class MainController {

    private ClinicManager manager;

    @FXML private TableView<Appointment> appointmentTable;
    @FXML private TableColumn<Appointment, Object> doctorColumn;
    @FXML private TableColumn<Appointment, Object> patientColumn;
    @FXML private TableColumn<Appointment, Object> dateTimeColumn;

    @FXML
    public void initialize() {
        manager = new ClinicManager();
        System.out.println("Dashboard Loaded! ClinicManager is ready.");

        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patient"));
        dateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDateTime"));

        // Fixed: Added the missing closing bracket for the if-statement here
        if (manager != null) {
            appointmentTable.setItems(FXCollections.observableArrayList(manager.getAppointments()));
        }
    } // Fixed: Properly closing the initialize method block

    @FXML
    public void openPatientForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/PatientForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);

            scene.getStylesheets().add(getClass().getResource("/com/euroclinic/hellenicclinic/css/style.css").toExternalForm());

            PatientController popupController = fxmlLoader.getController();
            popupController.setManager(this.manager);

            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Patient");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Error loading Patient window: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void openDoctorForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/DoctorForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);

            scene.getStylesheets().add(getClass().getResource("/com/euroclinic/hellenicclinic/css/style.css").toExternalForm());

            DoctorController popupController = fxmlLoader.getController();
            popupController.setManager(this.manager);

            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Doctor");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Error loading Doctor window: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void openAppointmentForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/AppointmentForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 450);
            scene.getStylesheets().add(getClass().getResource("/com/euroclinic/hellenicclinic/css/style.css").toExternalForm());


            AppointmentController popupController = fxmlLoader.getController();
            popupController.setManager(this.manager);

            Stage popupStage = new Stage();
            popupStage.setTitle("Book Appointment");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

            // Force reload the list from the manager's standard ArrayList structure
            if (manager != null) {
                appointmentTable.setItems(FXCollections.observableArrayList(manager.getAppointments()));
            }
            appointmentTable.refresh();

        } catch (Exception e) {
            System.out.println("Error loading Appointment window: " + e.getMessage());
            e.printStackTrace();
        }
    }
}