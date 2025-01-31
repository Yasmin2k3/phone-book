import java.util.ArrayList;

public class Address {
    private String nickname, firstName, surname, group;
    String mobileNumbers, homeNumbers, businessNumbers, emails;
    Date birthday;
    private boolean emergencyContact = false;

    public Address(String nickname, String firstName, String surname, String mobileNumbers, String homeNumbers, String businessNumbers, String emails, Date birthday){

    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(boolean emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
