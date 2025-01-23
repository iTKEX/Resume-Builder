package advancedprogramming.resumebuilder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author tkex_
 */
public class generatePDF {

    public static void generatePDF() {
        //personal Infomation
        String name = PrimaryController.user.getName();
        String phoneNumber = PrimaryController.user.getPhoneNumber();
        String email = PrimaryController.user.getEmail();
        String dateOfBirdth = PrimaryController.user.getDateOfbirth();
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

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Resume.pdf"));
            document.open();

            // Add content to the PDF
            document.addTitle("Reusme : ");
            document.add(new Paragraph("Personal Information:\n"));
            document.add(new Paragraph("Name: " + name + "                            Phone Number: " + phoneNumber));
            document.add(new Paragraph("Email: " + email + "                            Date Of Birth: " + dateOfBirdth));
            document.add(new Paragraph("Address: " + address));
            document.add(new Paragraph("______________________________________________________________________________"));
            if (firstQualificationProgram.isEmpty()) {
            } else {
                document.add(new Paragraph("\nQualification Information:"));
                document.add(new Paragraph("Qualification Program: " + firstQualificationProgram
                        + "    Grade : " + firstQualificationGrade + "    Passing Year : " + firstQualificationPassingYear));
            }
            if (secondQualificationGrade.isEmpty()) {

            } else {
                document.add(new Paragraph("Qualification Program: " + secondQualificationProgram
                        + "    Grade : " + secondQualificationGrade + "    Passing Year : " + secondQualificationPassingYear));
            }
            if (thirdQualificationProgram.isEmpty()) {
            } else {
                document.add(new Paragraph("Qualification Program: " + thirdQualificationProgram
                        + "    Grade : " + thirdQualificationGrade + "    Passing Year : " + thirdQualificationPassingYear));
            }

            if (firstOrganization.isEmpty()) {
            } else {
                document.add(new Paragraph("______________________________________________________________________________"));
                document.add(new Paragraph("\nExperience Information:"));

                document.add(new Paragraph("Organization: " + firstOrganization + "    Designation: " + firstDesignation
                        + "     " + firstStartExperience + " - " + firstEndExperience));
                if (secondOrganization.isEmpty()) {
                } else {
                    document.add(new Paragraph("Organization: " + secondOrganization + "    Designation: " + secondDesignation
                            + "     " + secondStartExperience + " - " + secondEndExperience));
                }
                if (thirdOrganization.isEmpty()) {
                } else {
                    document.add(new Paragraph("Organization: " + thirdOrganization + "    Designation: " + thirdDesignation
                            + "     " + thirdStartExperience + " - " + thirdEndExperience));
                }
            }
            if (firstComputerSkill.isEmpty() && firstLanguage.isEmpty() && firstSportSkill.isEmpty()) {
            } else {
                document.add(new Paragraph("______________________________________________________________________________"));
                document.add(new Paragraph("\nSkills Information:"));
                if (firstComputerSkill.isEmpty()) {

                } else {
                    document.add(new Paragraph("\nComputer Skills : " + firstComputerSkill + ", " + secondComputerSkill
                            + ", " + thirdComputerSkill + ", " + fourthComputerSkill));
                }
                if (firstLanguage.isEmpty()) {

                } else {
                    document.add(new Paragraph("\nLangugaes : " + firstLanguage + ", " + secondLanguage
                            + ", " + thirdLanguage + ", " + fourthLanguage));
                }
                if (firstSportSkill.isEmpty()) {

                } else {
                    document.add(new Paragraph("\nSports : " + firstSportSkill + ", " + secondSportSkill
                            + ", " + thirdSportSkill + ", " + fourthSportSkill));
                }
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
