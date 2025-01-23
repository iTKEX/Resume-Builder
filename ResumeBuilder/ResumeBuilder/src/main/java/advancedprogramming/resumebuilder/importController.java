package advancedprogramming.resumebuilder;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author tkex_
 */
public class importController {

    static ImportFromDatabase importResumeFromDatabase = new ImportFromDatabase();
    
    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberFiled;

    @FXML
    private Button closeButton;

    @FXML
    private Button importButton;
        
    @FXML
    private void exit() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void importResume() throws IOException {
        importResumeFromDatabase.importResume(nameField.getText(),phoneNumberFiled.getText());
        App.setRoot("primary");
    }
}
