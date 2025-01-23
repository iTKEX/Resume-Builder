package advancedprogramming.resumebuilder;

import advancedprogramming.resumebuilder.App;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ThirdController {

    String firstOrganization, firstDesignation, firstStartExperience, firstEndExperience,
            secondOrganization, secondDesignation, secondStartExperience, secondEndExperience,
            thirdOrganization, thirdDesignation, thirdStartExperience, thirdEndExperience;

    static ExperienceInformation user = new ExperienceInformation();

    ObservableList<String> yearsList = FXCollections.observableArrayList("1995", "1996",
            "1997", "1998", " 1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
            "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
            "2022", "2023");

    @FXML
    private TextField firstOrganizationField;

    @FXML
    private TextField secondOrganizationField;

    @FXML
    private TextField thirdOrganizationField;

    @FXML
    private TextField firstDesignationField;

    @FXML
    private TextField secondDesignationField;

    @FXML
    private TextField thirdDesignationField;

    @FXML
    private ChoiceBox firstStartExperienceField;
    @FXML
    private ChoiceBox firstEndExperienceField;

    @FXML
    private ChoiceBox secondStartExperienceField;
    @FXML
    private ChoiceBox secondEndExperienceField;

    @FXML
    private ChoiceBox thirdStartExperienceField;
    @FXML
    private ChoiceBox thirdEndExperienceField;

    @FXML
    void initialize() {
        firstStartExperienceField.setItems(yearsList);
        firstEndExperienceField.setItems(yearsList);

        secondStartExperienceField.setItems(yearsList);
        secondEndExperienceField.setItems(yearsList);

        thirdStartExperienceField.setItems(yearsList);
        thirdEndExperienceField.setItems(yearsList);

        firstOrganizationField.setText(user.firstOrganization);
        firstDesignationField.setText(user.firstDesignation);

        secondOrganizationField.setText(user.secondOrganization);
        secondDesignationField.setText(user.secondDesignation);

        thirdOrganizationField.setText(user.thirdOrganization);
        thirdDesignationField.setText(user.thirdDesignation);

    }

    private void setExperienceInformation() {
        firstOrganization = firstOrganizationField.getText();
        firstDesignation = firstDesignationField.getText();
        firstStartExperience = (String) firstStartExperienceField.getValue();
        firstEndExperience = (String) firstEndExperienceField.getValue();

        secondOrganization = secondOrganizationField.getText();
        secondDesignation = secondDesignationField.getText();
        secondStartExperience = (String) secondStartExperienceField.getValue();
        secondEndExperience = (String) secondEndExperienceField.getValue();

        thirdOrganization = thirdOrganizationField.getText();
        thirdDesignation = thirdDesignationField.getText();
        thirdStartExperience = (String) thirdStartExperienceField.getValue();
        thirdEndExperience = (String) thirdEndExperienceField.getValue();

        user.setFirstOrganization(firstOrganization);
        user.setFirstDesignation(firstDesignation);
        user.setFirstStartExperience(firstStartExperience);
        user.setFirstEndExperience(firstEndExperience);

        user.setSecondOrganization(secondOrganization);
        user.setSecondDesignation(secondDesignation);
        user.setSecondStartExperience(secondStartExperience);
        user.setSecondEndExperience(secondEndExperience);

        user.setThirdOrganization(thirdOrganization);
        user.setThirdDesignation(thirdDesignation);
        user.setThirdStartExperience(thirdStartExperience);
        user.setThirdEndExperience(thirdEndExperience);
    }

    @FXML
    private void nextPage() throws IOException {
        setExperienceInformation();
        App.setRoot("fourth");
    }

    @FXML
    private void backPage() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void exit() throws IOException {
        System.exit(0);
    }
}
