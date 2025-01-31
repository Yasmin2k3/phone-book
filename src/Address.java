import java.util.ArrayList;
import java.util.regex.Pattern;

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
    private final int charCap = 50;
    private boolean validateFirstName()
    {
        return this.firstName.length()<=charCap;
    }
    private boolean validateSurName()
    {
        return this.surname.length()<=charCap;
    }
    private boolean validateNickname()
    {
        return this.nickname.length()<=charCap;
    }
    private boolean validateGroup()
    {
        return this.group.length()<=charCap;
    }
    private boolean __validationNumberMethod(ArrayList<String> list)
    {
        boolean valid = true;
        int min = 9;
        int max = 15;
        for (int i = 0; i < list.size(); i++) {
            int curNumLength = list.get(i).length();
            if(curNumLength< min || curNumLength >max)
            {
                valid = false;
            }
            else
            {
                continue;
            }

        }
        return valid;
    }

    private boolean validateMobileNumbers()
    {
        return __validationNumberMethod(this.mobileNumbers);
    }
    private boolean validateHomeNumbers()
    {
        return __validationNumberMethod(this.homeNumbers);
    }
    private boolean validateBusinessNumbers()
    {
        return __validationNumberMethod(this.businessNumbers);
    }

    private boolean validateEmails()
    {
        boolean valid = true;
        for (int i = 0; i < this.emails.size(); i++)
        {

            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern p = Pattern.compile(emailRegex);
            if(!p.matcher(this.emails.get(i)).matches())
            {
                valid=false;
            }
        }
        return valid;
    }

}
