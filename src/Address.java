import java.util.ArrayList;
import java.util.regex.Pattern;

public class Address {
    private String nickname, firstName, surname, group;
    String mobileNumbers, homeNumbers, businessNumbers, emails;
    Date birthday;
    private boolean emergencyContact = false;

    private final int charCap = 50;

    public Address(String nickname, String firstName, String surname, String mobileNumbers, String homeNumbers, String businessNumbers, String emails, Date birthday){

        if (validate(mobileNumbers, homeNumbers, businessNumbers)) {
            this.nickname=nickname;
            this.firstName=firstName;
            this.surname=surname;
            this.mobileNumbers=mobileNumbers;
            this.homeNumbers = homeNumbers;
            this.businessNumbers=businessNumbers;
            this.emails = emails;
            this.birthday = birthday;
              } else {
            throw new RuntimeException();
        }
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

    private boolean validate(String mobileNumbers, String homeNumbers, String businessNumbers){
        return (validateFirstName() && validateSurName() && validateNickname() && validateGroup() && __validationNumberMethod(mobileNumbers)
         && __validationNumberMethod(homeNumbers) && __validationNumberMethod(businessNumbers) && validateEmail());
    }

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
//    private boolean __validationNumberMethod(ArrayList<String> list)
//    {
//        boolean valid = true;
//        int min = 9;
//        int max = 15;
//        for (int i = 0; i < list.size(); i++) {
//            int curNumLength = list.get(i).length();
//            if(curNumLength< min || curNumLength >max)
//            {
//                valid = false;
//            }
//            else
//            {
//                continue;
//            }
//
//        }
//        return valid;
//    }

    private boolean __validationNumberMethod(String phoneNumber)
    {
        int min = 9;
        int max = 15;

        return(phoneNumber.length()< min || phoneNumber.length() >max);
    }

    //Don't need these
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

//    private boolean validateEmails()
//    {
//        boolean valid = true;
//        for (int i = 0; i < this.emails.size(); i++)
//        {
//
//            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//            Pattern p = Pattern.compile(emailRegex);
//            if(!p.matcher(this.emails.get(i)).matches())
//            {
//                valid=false;
//            }
//        }
//        return valid;
//    }

    private boolean validateEmail()
    {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern p = Pattern.compile(emailRegex);
            return(!p.matcher(this.emails).hasMatch());
    }

}
