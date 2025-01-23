package advancedprogramming.resumebuilder;

/**
 *
 * @author tkex_
 */
import advancedprogramming.resumebuilder.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FourthController {

    String firstComputerSkill, secondComputerSkill, thirdComputerSkill, fourthComputerSkill,
            firstLanguage, secondLanguage, thirdLanguage, fourthLanguage,
            firstSportSkill, secondSportSkill, thirdSportSkill, fourthSportSkill;

    static SkillsInformation user = new SkillsInformation();
    static SaveToDatabase save = new SaveToDatabase();
    
    @FXML
    private TextField fisrtComputerSkillField;

    @FXML
    private TextField secondComputerSkillField;

    @FXML
    private TextField thirdComputerSkillField;

    @FXML
    private TextField fourthComputerSkillField;

    @FXML
    private TextField firstLanguageField;

    @FXML
    private TextField secondLanguageField;

    @FXML
    private TextField thirdLanguageField;

    @FXML
    private TextField fourthLanguageField;

    @FXML
    private TextField firstSportField;

    @FXML
    private TextField secondSportField;

    @FXML
    private TextField thirdSportField;

    @FXML
    private TextField fourthSportField;

    @FXML
    void initialize() {
        fisrtComputerSkillField.setText(user.firstComputerSkill);
        secondComputerSkillField.setText(user.secondComputerSkill);
        thirdComputerSkillField.setText(user.thirdComputerSkill);
        fourthComputerSkillField.setText(user.fourthComputerSkill);

        firstLanguageField.setText(user.firstLanguage);
        secondLanguageField.setText(user.secondLanguage);
        thirdLanguageField.setText(user.thirdLanguage);
        fourthLanguageField.setText(user.fourthLanguage);

        firstSportField.setText(user.firstSportSkill);
        secondSportField.setText(user.secondSportSkill);
        thirdSportField.setText(user.thirdSportSkill);
        fourthSportField.setText(user.fourthSportSkill);
    }

    private void setSkillsInformation() {

        firstComputerSkill = fisrtComputerSkillField.getText();
        secondComputerSkill = secondComputerSkillField.getText();
        thirdComputerSkill = thirdComputerSkillField.getText();
        fourthComputerSkill = fourthComputerSkillField.getText();

        firstLanguage = firstLanguageField.getText();
        secondLanguage = secondLanguageField.getText();
        thirdLanguage = thirdLanguageField.getText();
        fourthLanguage = fourthLanguageField.getText();

        firstSportSkill = firstSportField.getText();
        secondSportSkill = secondSportField.getText();
        thirdSportSkill = thirdSportField.getText();
        fourthSportSkill = fourthSportField.getText();

        user.setFirstComputerSkill(firstComputerSkill);
        user.setSecondComputerSkill(secondComputerSkill);
        user.setThirdComputerSkill(thirdComputerSkill);
        user.setFourthComputerSkill(fourthComputerSkill);

        user.setFirstLanguage(firstLanguage);
        user.setSecondLanguage(secondLanguage);
        user.setThirdLanguage(thirdLanguage);
        user.setFourthLanguage(fourthLanguage);

        user.setFirstSportSkill(firstSportSkill);
        user.setSecondSportSkill(secondSportSkill);
        user.setThirdSportSkill(thirdSportSkill);
        user.setFourthSportSkill(fourthSportSkill);

    }

    @FXML
    private void saveOption() throws IOException {

    }

    @FXML
    private void finishOption() throws IOException {
        setSkillsInformation();
        generatePDF.generatePDF();
        System.exit(0);
    }

    @FXML
    private void backPage() throws IOException {
        App.setRoot("third");
    }

    @FXML
    private void exit() throws IOException {
        System.exit(0);
    }

    @FXML
    private void insertToDatabase() throws IOException {
        setSkillsInformation();
        save.insertResume();
    }
}
