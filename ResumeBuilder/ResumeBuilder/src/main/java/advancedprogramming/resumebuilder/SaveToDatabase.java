package advancedprogramming.resumebuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author tkex_
 */
public class SaveToDatabase {

    static Scene scene;
    static Stage dataBaseValidate = new Stage();

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static final String URL = "jdbc:mysql://localhost:3306/resumes";
    private static final String USER = "ADuser";
    private static final String PASSWORD = "12341234AD@";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    // Method to insert values into the resumes table
    public static void insertResume() throws IOException {
        //personal Infomation
        String name = PrimaryController.user.getName();
        String phoneNumber = PrimaryController.user.getPhoneNumber();
        String email = PrimaryController.user.getEmail();
        String dateOfBirth = PrimaryController.user.getDateOfbirth();
        String address = PrimaryController.user.getAddress();

        // Qualification Information
        String firstQualificationProgram = SecondaryController.user.getFirstQualificationProgram();
        String firstQualificationGrade = SecondaryController.user.getFirstQualificationGrade();
        String firstQualificationPassingYear = SecondaryController.user.getFirstQualificationPassingYear();

        String secondQualificationProgram = SecondaryController.user.getSecondQualificationProgram();
        String secondQualificationGrade = SecondaryController.user.getSecondQualificationGrade();
        String secondQualificationPassingYear = SecondaryController.user.getSecondQualificationPassingyear();

        String thirdQualificationProgram = SecondaryController.user.getThirdQualificationProgram();
        String thirdQualificationGrade = SecondaryController.user.getThirdQualificationGrade();
        String thirdQualificationPassingYear = SecondaryController.user.getThirdQualificationPassingYear();

        //Experience Information 
        String firstOrganization = ThirdController.user.getFirstOrganization();
        String firstDesignation = ThirdController.user.getFirstDesignation();
        String firstStartExperience = ThirdController.user.getFirstStartExperience();
        String firstEndExperience = ThirdController.user.getFirstEndExperience();

        String secondOrganization = ThirdController.user.getSecondOrganization();
        String secondDesignation = ThirdController.user.getSecondDesignation();
        String secondStartExperience = ThirdController.user.getSecondStartExperience();
        String secondEndExperience = ThirdController.user.getSecondEndExperience();

        String thirdOrganization = ThirdController.user.getThirdOrganization();
        String thirdDesignation = ThirdController.user.getThirdDesignation();
        String thirdStartExperience = ThirdController.user.getThirdStartExperience();
        String thirdEndExperience = ThirdController.user.getThirdEndExperience();

        // Skills Information 
        String firstComputerSkill = FourthController.user.getFirstComputerSkill();
        String secondComputerSkill = FourthController.user.getSecondComputerSkill();
        String thirdComputerSkill = FourthController.user.getThirdComputerSkill();
        String fourthComputerSkill = FourthController.user.getFourthComputerSkill();

        String firstLanguage = FourthController.user.getFirstLanguage();
        String secondLanguage = FourthController.user.getSecondLanguage();
        String thirdLanguage = FourthController.user.getThirdLanguage();
        String fourthLanguage = FourthController.user.getFourthLanguage();

        String firstSportSkill = FourthController.user.getFirstSportSkill();
        String secondSportSkill = FourthController.user.getSecondSportSkill();
        String thirdSportSkill = FourthController.user.getThirdSportSkill();
        String fourthSportSkill = FourthController.user.getFourthSportSkill();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to check if the record already exists
            String selectQuery = "SELECT * FROM resumes WHERE name = ? AND phoneNumber = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            resultSet = preparedStatement.executeQuery();

            // Check if the record already exists
            if (resultSet.next()) {
                boolean sameData = name.equals(resultSet.getString("name"))
                        && phoneNumber.equals(resultSet.getString("phoneNumber"))
                        && email.equals(resultSet.getString("email"))
                        && dateOfBirth.equals(resultSet.getString("dateOfBirth"))
                        && address.equals(resultSet.getString("address"))
                        && firstQualificationProgram.equals(resultSet.getString("firstQualificationProgram"))
                        && firstQualificationGrade.equals(resultSet.getString("firstQualificationGrade"))
                        && secondQualificationProgram.equals(resultSet.getString("secondQualificationProgram"))
                        && secondQualificationGrade.equals(resultSet.getString("secondQualificationGrade"))
                        && thirdQualificationProgram.equals(resultSet.getString("thirdQualificationProgram"))
                        && thirdQualificationGrade.equals(resultSet.getString("thirdQualificationGrade"))
                        && firstOrganization.equals(resultSet.getString("firstOrganization"))
                        && firstDesignation.equals(resultSet.getString("firstDesignation"))
                        && secondOrganization.equals(resultSet.getString("secondOrganization"))
                        && secondDesignation.equals(resultSet.getString("secondDesignation"))
                        && thirdOrganization.equals(resultSet.getString("thirdOrganization"))
                        && thirdDesignation.equals(resultSet.getString("thirdDesignation"))
                        && firstComputerSkill.equals(resultSet.getString("firstComputerSkill"))
                        && secondComputerSkill.equals(resultSet.getString("secondComputerSkill"))
                        && thirdComputerSkill.equals(resultSet.getString("thirdComputerSkill"))
                        && fourthComputerSkill.equals(resultSet.getString("fourthComputerSkill"))
                        && firstLanguage.equals(resultSet.getString("firstLanguage"))
                        && secondLanguage.equals(resultSet.getString("secondLanguage"))
                        && thirdLanguage.equals(resultSet.getString("thirdLanguage"))
                        && fourthLanguage.equals(resultSet.getString("fourthLanguage"))
                        && firstSportSkill.equals(resultSet.getString("firstSport"))
                        && secondSportSkill.equals(resultSet.getString("secondSport"))
                        && thirdSportSkill.equals(resultSet.getString("thirdSport"))
                        && fourthSportSkill.equals(resultSet.getString("fourthSport"));

                if (sameData) {
                    scene = new Scene(loadFXML("InsertToDatabaseValidate"));
                    dataBaseValidate.setTitle("Error");
                    dataBaseValidate.setScene(scene);
                    dataBaseValidate.setResizable(false);
                    dataBaseValidate.show();
                } else {
                    // Close resources
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();

                    // Update the record
                    updateResume();
                }
            } else {
                // SQL query to insert values into the resumes table
                String insertQuery = "INSERT INTO resumes (name, phoneNumber, email, dateOfBirth, address, "
                        + "firstQualificationProgram, firstQualificationGrade, firstQualificationPassingYear, "
                        + "secondQualificationProgram, secondQualificationGrade, secondQualificationPassingYear, "
                        + "thirdQualificationProgram, thirdQualificationGrade, thirdQualificationPassingYear, "
                        + "firstOrganization, firstDesignation, firstStartExperience, firstEndExperience, "
                        + "secondOrganization, secondDesignation, secondStartExperience, secondEndExperience, "
                        + "thirdOrganization, thirdDesignation, thirdStartExperience, thirdEndExperience, "
                        + "firstComputerSkill, secondComputerSkill, thirdComputerSkill, fourthComputerSkill, "
                        + "firstLanguage, secondLanguage, thirdLanguage, fourthLanguage, "
                        + "firstSport, secondSport, thirdSport, fourthSport) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertQuery);

                // Set parameter values
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phoneNumber);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, dateOfBirth);
                preparedStatement.setString(5, address);
                // Qualification parameters
                preparedStatement.setString(6, firstQualificationProgram);
                preparedStatement.setString(7, firstQualificationGrade);
                preparedStatement.setString(8, firstQualificationPassingYear);
                preparedStatement.setString(9, secondQualificationProgram);
                preparedStatement.setString(10, secondQualificationGrade);
                preparedStatement.setString(11, secondQualificationPassingYear);
                preparedStatement.setString(12, thirdQualificationProgram);
                preparedStatement.setString(13, thirdQualificationGrade);
                preparedStatement.setString(14, thirdQualificationPassingYear);
                // Experience parameters
                preparedStatement.setString(15, firstOrganization);
                preparedStatement.setString(16, firstDesignation);
                preparedStatement.setString(17, firstStartExperience);
                preparedStatement.setString(18, firstEndExperience);
                preparedStatement.setString(19, secondOrganization);
                preparedStatement.setString(20, secondDesignation);
                preparedStatement.setString(21, secondStartExperience);
                preparedStatement.setString(22, secondEndExperience);
                preparedStatement.setString(23, thirdOrganization);
                preparedStatement.setString(24, thirdDesignation);
                preparedStatement.setString(25, thirdStartExperience);
                preparedStatement.setString(26, thirdEndExperience);
                // Skills parameters
                preparedStatement.setString(27, firstComputerSkill);
                preparedStatement.setString(28, secondComputerSkill);
                preparedStatement.setString(29, thirdComputerSkill);
                preparedStatement.setString(30, fourthComputerSkill);
                preparedStatement.setString(31, firstLanguage);
                preparedStatement.setString(32, secondLanguage);
                preparedStatement.setString(33, thirdLanguage);
                preparedStatement.setString(34, fourthLanguage);
                preparedStatement.setString(35, firstSportSkill);
                preparedStatement.setString(36, secondSportSkill);
                preparedStatement.setString(37, thirdSportSkill);
                preparedStatement.setString(38, fourthSportSkill);

                // Execute the insert query
                preparedStatement.executeUpdate();
                scene = new Scene(loadFXML("addToDatabaseAccept"));
                dataBaseValidate.setTitle("Accept");
                dataBaseValidate.setScene(scene);
                dataBaseValidate.setResizable(false);
                dataBaseValidate.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateResume() throws IOException {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to update values in the resumes table
            String updateQuery = "UPDATE resumes SET email = ?, dateOfBirth = ?, address = ?, "
                    + "firstQualificationProgram = ?, firstQualificationGrade = ?, firstQualificationPassingYear = ?, "
                    + "secondQualificationProgram = ?, secondQualificationGrade = ?, secondQualificationPassingYear = ?, "
                    + "thirdQualificationProgram = ?, thirdQualificationGrade = ?, thirdQualificationPassingYear = ?, "
                    + "firstOrganization = ?, firstDesignation = ?, firstStartExperience = ?, firstEndExperience = ?, "
                    + "secondOrganization = ?, secondDesignation = ?, secondStartExperience = ?, secondEndExperience = ?, "
                    + "thirdOrganization = ?, thirdDesignation = ?, thirdStartExperience = ?, thirdEndExperience = ?, "
                    + "firstComputerSkill = ?, secondComputerSkill = ?, thirdComputerSkill = ?, fourthComputerSkill = ?, "
                    + "firstLanguage = ?, secondLanguage = ?, thirdLanguage = ?, fourthLanguage = ?, "
                    + "firstSport = ?, secondSport = ?, thirdSport = ?, fourthSport = ? "
                    + "WHERE name = ? AND phoneNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set parameter values
            // Set parameters for personal information
            preparedStatement.setString(1, PrimaryController.user.getEmail());
            preparedStatement.setString(2, PrimaryController.user.getDateOfbirth());
            preparedStatement.setString(3, PrimaryController.user.getAddress());
            // Set parameters for qualifications
            preparedStatement.setString(4, SecondaryController.user.getFirstQualificationProgram());
            preparedStatement.setString(5, SecondaryController.user.getFirstQualificationGrade());
            preparedStatement.setString(6, SecondaryController.user.getFirstQualificationPassingYear());
            preparedStatement.setString(7, SecondaryController.user.getSecondQualificationProgram());
            preparedStatement.setString(8, SecondaryController.user.getSecondQualificationGrade());
            preparedStatement.setString(9, SecondaryController.user.getSecondQualificationPassingyear());
            preparedStatement.setString(10, SecondaryController.user.getThirdQualificationProgram());
            preparedStatement.setString(11, SecondaryController.user.getThirdQualificationGrade());
            preparedStatement.setString(12, SecondaryController.user.getThirdQualificationPassingYear());
            // Set parameters for experience
            preparedStatement.setString(13, ThirdController.user.getFirstOrganization());
            preparedStatement.setString(14, ThirdController.user.getFirstDesignation());
            preparedStatement.setString(15, ThirdController.user.getFirstStartExperience());
            preparedStatement.setString(16, ThirdController.user.getFirstEndExperience());
            preparedStatement.setString(17, ThirdController.user.getSecondOrganization());
            preparedStatement.setString(18, ThirdController.user.getSecondDesignation());
            preparedStatement.setString(19, ThirdController.user.getSecondStartExperience());
            preparedStatement.setString(20, ThirdController.user.getSecondEndExperience());
            preparedStatement.setString(21, ThirdController.user.getThirdOrganization());
            preparedStatement.setString(22, ThirdController.user.getThirdDesignation());
            preparedStatement.setString(23, ThirdController.user.getThirdStartExperience());
            preparedStatement.setString(24, ThirdController.user.getThirdEndExperience());
            // Set parameters for skills
            preparedStatement.setString(25, FourthController.user.getFirstComputerSkill());
            preparedStatement.setString(26, FourthController.user.getSecondComputerSkill());
            preparedStatement.setString(27, FourthController.user.getThirdComputerSkill());
            preparedStatement.setString(28, FourthController.user.getFourthComputerSkill());
            preparedStatement.setString(29, FourthController.user.getFirstLanguage());
            preparedStatement.setString(30, FourthController.user.getSecondLanguage());
            preparedStatement.setString(31, FourthController.user.getThirdLanguage());
            preparedStatement.setString(32, FourthController.user.getFourthLanguage());
            preparedStatement.setString(33, FourthController.user.getFirstSportSkill());
            preparedStatement.setString(34, FourthController.user.getSecondSportSkill());
            preparedStatement.setString(35, FourthController.user.getThirdSportSkill());
            preparedStatement.setString(36, FourthController.user.getFourthSportSkill());
            // Set parameters for identity
            preparedStatement.setString(37, PrimaryController.user.getName());
            preparedStatement.setString(38, PrimaryController.user.getPhoneNumber());

            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                scene = new Scene(loadFXML("updateDatabase"));
                dataBaseValidate.setTitle("Error");
                dataBaseValidate.setScene(scene);
                dataBaseValidate.setResizable(false);
                dataBaseValidate.show();
            } else {
                System.out.println("Failed to update resume.");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
