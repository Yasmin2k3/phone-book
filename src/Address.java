import java.util.ArrayList;

public class Address {
    private String nickname, firstName, surname;
    ArrayList<String> mobileNumbers, homeNumbers, businessNumbers, emails;
    Date birthday;
    private boolean emergencyContact = false;

    public boolean isEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(boolean emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
