package com.example.midterm_section_1_2330951;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class HelloController {

    @FXML
    private TextField priceField;
    @FXML
    private ComboBox<String> availibilityComboBox;
    @FXML
    private ComboBox<String> validityChoiceBox;
    @FXML
    private TextField dataAmountField;
    @FXML
    private TextField pacakageNameField;
    @FXML
    private TableColumn<DataPackage,String> availibilityTableCol;
    @FXML
    private TableColumn<DataPackage,Double> priceTableCol;
    @FXML
    private Label bestValuePackageLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private TableColumn<DataPackage,String> packageNameTableCol;
    @FXML
    private TableColumn<DataPackage,Float> dataAmountTableCol;
    @FXML
    private TableColumn<DataPackage, LocalDate> offerEndsTableCol;
    @FXML
    private TableColumn<DataPackage,String> validityTableCol;
    @FXML
    private ComboBox<String> filterChoiceBox;
    @FXML
    private DatePicker datePickerField;
    @FXML
    private TableView<DataPackage> packageTableView;

    @FXML
    void initialize() {
        validityChoiceBox.getItems().addAll( "3 days", "7 days", "15 days", "30 days", "Unlimited");
        availibilityComboBox.getItems().addAll( "App Only",
                "Recharge Only",
                "App and Recharge only");

        packageNameTableCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dataAmountTableCol.setCellValueFactory(new PropertyValueFactory<>("dataAmount"));
        validityTableCol.setCellValueFactory(new PropertyValueFactory<>("validity"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        availibilityTableCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        offerEndsTableCol.setCellValueFactory(new PropertyValueFactory<>("offerEnds"));


    }

    @FXML
    public void createPackageButton(ActionEvent actionEvent) {
        if (pacakageNameField.getText().isBlank()){
            messageLabel.setText("Package name cannot be blank");
            return;
        }
        if (dataAmountField.getText().isBlank()){
            messageLabel.setText("Amount cannot be blank");
            return;
        }

        String name = pacakageNameField.getText();
        String dataAmount = dataAmountField.getText();
        String validity = validityChoiceBox.getValue();
        String price = priceField.getText();
        String availibility = availibilityComboBox.getValue();
        LocalDate offerEnds = datePickerField.getValue();

        DataPackage d = new DataPackage(name, Float.parseFloat(dataAmount),validity,Double.parseDouble(price),availibility,offerEnds);
        packageTableView.getItems().add(d);
    }

    @FXML
    public void filter(ActionEvent actionEvent) {

    }

    @FXML
    public void resetFilter(ActionEvent actionEvent) {
    }

    @FXML
    public void findBestValue(ActionEvent actionEvent) {
    }
}