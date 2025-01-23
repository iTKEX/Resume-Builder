package advancedprogramming.resumebuilder;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author tkex_
 */
public class InsertToDatabaseValidateController {

    @FXML
    private void exit() throws IOException {
        SaveToDatabase.dataBaseValidate.close();
    }

}
