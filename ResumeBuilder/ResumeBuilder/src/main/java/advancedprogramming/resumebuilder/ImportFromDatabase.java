package advancedprogramming.resumebuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author tkex_
 */
public class ImportFromDatabase {

    static Scene scene;
    static Stage dataBaseValidate = new Stage();

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static final String URL = "jdbc:mysql://localhost:3306/resumes";
    private static final String USER = "ADuser";
    private static final String PASSWORD = "12341234AD@";

    // Method to import values from the resumes table based on name and phoneNumber
    public static void importResume(String name, String phoneNumber) throws IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to retrieve data from the resumes table based on name and phoneNumber
            String selectQuery = "SELECT * FROM resumes WHERE name = ? AND phoneNumber = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            resultSet = preparedStatement.executeQuery();

            // Check if the record exists
            if (resultSet.next()) {
                PrimaryController.user.name = resultSet.getString("name");
                PrimaryController.user.phoneNumber = resultSet.getString("phoneNumber");
                PrimaryController.user.Email = resultSet.getString("email");
                PrimaryController.user.DateOfbirth = resultSet.getString("dateOfBirth");
                PrimaryController.user.address = resultSet.getString("address");

                SecondaryController.user.firstQualificationProgram = resultSet.getString("firstQualificationProgram");
                SecondaryController.user.firstQualificationGrade = resultSet.getString("firstQualificationGrade");
                SecondaryController.user.firstQualificationPassingYear = resultSet.getString("firstQualificationPassingYear");

                SecondaryController.user.secondQualificationProgram = resultSet.getString("secondQualificationProgram");
                SecondaryController.user.secondQualificationGrade = resultSet.getString("secondQualificationGrade");
                SecondaryController.user.secondQualificationPassingyear = resultSet.getString("secondQualificationPassingYear");

                SecondaryController.user.thirdQualificationProgram = resultSet.getString("thirdQualificationProgram");
                SecondaryController.user.thirdQualificationGrade = resultSet.getString("thirdQualificationGrade");
                SecondaryController.user.thirdQualificationPassingYear = resultSet.getString("thirdQualificationPassingYear");

                ThirdController.user.firstOrganization = resultSet.getString("firstOrganization");
                ThirdController.user.firstDesignation = resultSet.getString("firstDesignation");
                ThirdController.user.firstStartExperience = resultSet.getString("firstStartExperience");
                ThirdController.user.firstEndExperience = resultSet.getString("firstEndExperience");

                ThirdController.user.secondOrganization = resultSet.getString("secondOrganization");
                ThirdController.user.secondDesignation = resultSet.getString("secondDesignation");
                ThirdController.user.secondStartExperience = resultSet.getString("secondStartExperience");
                ThirdController.user.secondEndExperience = resultSet.getString("secondEndExperience");

                ThirdController.user.thirdOrganization = resultSet.getString("thirdOrganization");
                ThirdController.user.thirdDesignation = resultSet.getString("thirdDesignation");
                ThirdController.user.thirdStartExperience = resultSet.getString("thirdStartExperience");
                ThirdController.user.thirdEndExperience = resultSet.getString("thirdEndExperience");

                FourthController.user.firstComputerSkill = resultSet.getString("firstComputerSkill");
                FourthController.user.secondComputerSkill = resultSet.getString("secondComputerSkill");
                FourthController.user.thirdComputerSkill = resultSet.getString("thirdComputerSkill");
                FourthController.user.fourthComputerSkill = resultSet.getString("fourthComputerSkill");

                FourthController.user.firstLanguage = resultSet.getString("firstLanguage");
                FourthController.user.secondLanguage = resultSet.getString("secondLanguage");
                FourthController.user.thirdLanguage = resultSet.getString("thirdLanguage");
                FourthController.user.fourthLanguage = resultSet.getString("fourthLanguage");

                FourthController.user.firstSportSkill = resultSet.getString("firstSport");
                FourthController.user.secondSportSkill = resultSet.getString("secondSport");
                FourthController.user.thirdSportSkill = resultSet.getString("thirdSport");
                FourthController.user.fourthSportSkill = resultSet.getString("fourthSport");

                System.out.println("Data imported successfully.");
            } else {
                scene = new Scene(loadFXML("validateDataBase"));
                dataBaseValidate.setTitle("Error");
                dataBaseValidate.setScene(scene);
                dataBaseValidate.setResizable(false);
                dataBaseValidate.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
