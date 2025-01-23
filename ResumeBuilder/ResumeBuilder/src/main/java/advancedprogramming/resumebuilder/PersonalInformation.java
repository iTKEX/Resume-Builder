package advancedprogramming.resumebuilder;

/**
 *
 * @author tkex_
 */
public class PersonalInformation {

    String name, phoneNumber, Email, DateOfbirth, address;

    public PersonalInformation() {
        this.name = "";
        this.phoneNumber = "";
        this.Email = "";
        this.DateOfbirth = null;
        this.address = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDateOfbirth() {
        return DateOfbirth;
    }

    public void setDateOfbirth(String DateOfbirth) {
        this.DateOfbirth = DateOfbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

}
