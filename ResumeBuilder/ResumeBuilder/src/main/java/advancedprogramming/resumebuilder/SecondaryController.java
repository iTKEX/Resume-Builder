package advancedprogramming.resumebuilder;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SecondaryController {

    String firstQualificationProgram, firstQualificationGrade, firstQualificationPassingYear,
            secondQualificationProgram, secondQualificationGrade, secondQualificationPassingyear,
            thirdQualificationProgram, thirdQualificationGrade, thirdQualificationPassingYear;

    static QualificationInformation user = new QualificationInformation();

    ObservableList<String> yearsList = FXCollections.observableArrayList("1995", "1996",
            "1997", "1998", "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006", "2007", "2008",
            "2009", "2010", "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018", "2019", "2020",
            "2022", "2023");

    @FXML
    private TextField firstQualificationField, secondQualificationField, thirdQualificationField,
            firstGradeField, secondGradeField, thirdGradeField;

    @FXML
    private ComboBox firstPassingYear, secondPassingYear, thirdPassingYear;

    @FXML
    void initialize() {
        firstPassingYear.setItems(yearsList);
        secondPassingYear.setItems(yearsList);
        thirdPassingYear.setItems(yearsList);

        firstQualificationField.setText(user.firstQualificationProgram);
        firstGradeField.setText(user.firstQualificationGrade);

        secondQualificationField.setText(user.secondQualificationProgram);
        secondGradeField.setText(user.secondQualificationGrade);

        thirdQualificationField.setText(user.thirdQualificationProgram);
        thirdGradeField.setText(user.thirdQualificationGrade);
    }

    public void setQualificationInformation() {
        firstQualificationProgram = firstQualificationField.getText();
        firstQualificationGrade = firstGradeField.getText();
        firstQualificationPassingYear = (String) firstPassingYear.getValue();

        secondQualificationProgram = secondQualificationField.getText();
        secondQualificationGrade = secondGradeField.getText();
        secondQualificationPassingyear = (String) secondPassingYear.getValue();

        thirdQualificationProgram = thirdQualificationField.getText();
        thirdQualificationGrade = thirdGradeField.getText();
        thirdQualificationPassingYear = (String) thirdPassingYear.getValue();

        user.setFirstQualificationProgram(firstQualificationProgram);
        user.setFirstQualificationGrade(firstQualificationGrade);
        user.setFirstQualificationPassingYear(firstQualificationPassingYear);

        user.setSecondQualificationProgram(secondQualificationProgram);
        user.setSecondQualificationGrade(secondQualificationGrade);
        user.setSecondQualificationPassingyear(secondQualificationPassingyear);

        user.setThirdQualificationProgram(thirdQualificationProgram);
        user.setThirdQualificationGrade(thirdQualificationGrade);
        user.setThirdQualificationPassingYear(thirdQualificationPassingYear);
    }

    @FXML
    private void nextPage() throws IOException {
        setQualificationInformation();
        App.setRoot("third");
    }

    @FXML
    private void backPage() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void exit() throws IOException {
        System.exit(0);
    }
}
