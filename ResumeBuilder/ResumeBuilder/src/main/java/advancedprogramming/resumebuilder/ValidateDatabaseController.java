package advancedprogramming.resumebuilder;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author tkex_
 */
public class ValidateDatabaseController {

    @FXML
    private void exit() throws IOException{
       ImportFromDatabase.dataBaseValidate.close();
    }
}
