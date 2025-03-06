package com.example.midterm_section_1_2330951;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jfr.DataAmount;

import java.time.LocalDate;
import java.util.ArrayList;

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
    private TextField maxPriceField;

    private ArrayList<DataPackage> dataArrayList = new ArrayList<>();


    @FXML
    void initialize() {
        validityChoiceBox.getItems().addAll( "3 days", "7 days", "15 days", "30 days", "Unlimited");
        availibilityComboBox.getItems().addAll( "App Only",
                "Recharge Only",
                "App and Recharge only");

        filterChoiceBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");

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

        if (validityChoiceBox.getValue().isBlank()){
            messageLabel.setText("Validity cannot be blank");
            return;
        }
        if (priceField.getText().isBlank()){
            messageLabel.setText("Price cannot be blank");
            return;
        }
        if (availibilityComboBox.getValue().isBlank()){
            messageLabel.setText("Availability cannot be blank");
            return;
        }

        String name = pacakageNameField.getText();
        String dataAmount = dataAmountField.getText();
        String validity = validityChoiceBox.getValue();
        String price = priceField.getText();
        String availibility = availibilityComboBox.getValue();
        LocalDate offerEnds = datePickerField.getValue();

        for(DataPackage dataName: dataArrayList){
            if (dataName.getName().equals(name)){
                showAlert("Package name error." ,"Data package name must be unique.");
                return;
            }
        }

        DataPackage d = new DataPackage(name,Float.parseFloat(dataAmount),validity,Double.parseDouble(price),availibility,offerEnds);
        dataArrayList.add(d);
        packageTableView.getItems().setAll(dataArrayList);

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

    public void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}