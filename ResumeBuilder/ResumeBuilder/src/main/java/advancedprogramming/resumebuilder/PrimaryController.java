package advancedprogramming.resumebuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimaryController {

    String name, phoneNumber, email, dateOfBirth, address;
    static PersonalInformation user = new PersonalInformation();

    private List<Text> errorMessages = new ArrayList<>();

    @FXML
    private TextField nameField, phoneNumberField, emailField, addressField;

    @FXML
    private DatePicker dateOfBirdthField;

    @FXML
    private AnchorPane validiationPane;

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    void addErrorMessage(String message, double leftAnchor, double topAnchor) {
        Text text = new Text(message);
        text.setFont(Font.font("system", 12));
        text.setFill(Color.RED);
        AnchorPane.setLeftAnchor(text, leftAnchor);
        AnchorPane.setTopAnchor(text, topAnchor);
        errorMessages.add(text);
        validiationPane.getChildren().add(text);
    }

    public void validateFields() {
        // Clear existing error messages
        errorMessages.forEach(message -> validiationPane.getChildren().remove(message));
        errorMessages.clear();

        if (!Validation.stringValidation(nameField.getText())) {
            addErrorMessage("Invalid, Name should contain letters only", 340.0, 85.0);
            nameField.setStyle("-fx-border-color: red;");
        } else {
            nameField.setStyle("");
        }

        if (!Validation.numberValidation(phoneNumberField.getText())) {
            addErrorMessage("Invalid, Number should contain digits only and start with 05", 280.0, 150.0);
            phoneNumberField.setStyle("-fx-border-color: red;");
        } else {
            phoneNumberField.setStyle("");
        }

        if (!Validation.emailValidation(emailField.getText())) {
            addErrorMessage("Invalid, Email", 400.0, 215.0);
            emailField.setStyle("-fx-border-color: red;");
        } else {
            emailField.setStyle("");
        }

        if (!Validation.addressValidation(addressField.getText())) {
            addErrorMessage("You should fill Your address", 350.0, 345.0);
            addressField.setStyle("-fx-border-color: red;");
        } else {
            addressField.setStyle("");
        }
    }

    private void setPersonalInformation() {
        name = nameField.getText();
        phoneNumber = phoneNumberField.getText();
        email = emailField.getText();
        dateOfBirth = dateOfBirdthField.getValue().toString();
        address = addressField.getText();

        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setDateOfbirth(dateOfBirth);
        user.setAddress(address);

    }

    @FXML
    void initialize() {

        dateOfBirdthField.setValue(LOCAL_DATE("01-01-1995"));

        nameField.setText(user.name);
        phoneNumberField.setText(user.phoneNumber);
        emailField.setText(user.Email);
        addressField.setText(user.address);
    }

    @FXML
    private void importScene() throws IOException {
        App.setRoot("import");
    }

    @FXML
    private void nextPage(ActionEvent event) throws IOException {

        validateFields();

        if (errorMessages.isEmpty()) {
            setPersonalInformation();
            App.setRoot("secondary");
        }
    }

    @FXML
    private void exit() throws IOException {
        System.exit(0);
    }

}
