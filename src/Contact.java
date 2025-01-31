import java.util.regex.Pattern;

public class Contact {
    private String nickname, firstName, surname;
    String mobileNumbers, homeNumbers, businessNumbers, email;
    Date birthday;
    private boolean emergencyContact = false;

    private final int charCap = 50;

    //add email
    public Contact(String nickname, String firstName, String surname, String mobileNumbers, String homeNumbers, String businessNumbers, Date birthday){

        if (validate(firstName, surname, nickname, mobileNumbers, homeNumbers, businessNumbers)) {
            this.nickname=nickname;
            this.firstName=firstName;
            this.surname=surname;
            this.mobileNumbers=mobileNumbers;
            this.homeNumbers = homeNumbers;
            this.businessNumbers=businessNumbers;
            this.email = email;
            this.birthday = birthday;
              } else {
            throw new RuntimeException("Validation failed");
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

    private boolean validate(String firstName, String surname, String nickname, String mobileNumbers, String homeNumbers, String businessNumbers){
        return (validateFirstName(firstName) && validateSurName(surname) && validateNickname(nickname) && __validationNumberMethod(mobileNumbers)
         && __validationNumberMethod(homeNumbers) && __validationNumberMethod(businessNumbers));
    }

    private boolean validateFirstName(String firstName)
    {
        return firstName.length()<=charCap;
    }
    private boolean validateSurName(String surname)
    {
        return surname.length()<=charCap;
    }
    private boolean validateNickname(String nickname)
    {
        return nickname.length()<=charCap;
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

//    private boolean validateEmail(String email)
//    {
//            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//            Pattern p = Pattern.compile(emailRegex);
//            return(!p.matcher(email).hasMatch());
//    }

    public String toString(){
        return String.format(
                "Nickname: %s%nContact Number: %s%nFirst Name: %s%nSurname: %s%nEmail: %s%nBirthday: %s%nHome Number: %s%nBusiness Number: %s%n",
                this.nickname,
                this.mobileNumbers,
                this.firstName,
                this.surname,
                this.email,
                this.birthday,
                this.homeNumbers,
                this.businessNumbers);


    }

}
