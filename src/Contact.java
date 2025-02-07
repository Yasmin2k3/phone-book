import java.util.regex.Pattern;

public class Contact {
    private String nickname, firstName, surname;
    String mobileNumbers, homeNumbers, businessNumbers, email;
    Date birthday;
    private boolean emergencyContact = false;

    private final int charCap = 50;

    public Contact(String nickname, String firstName, String surname, String mobileNumbers, String homeNumbers, String businessNumbers, Date birthday){

        try{
           validate(firstName, surname, nickname, mobileNumbers, homeNumbers, businessNumbers);
            this.nickname=nickname;
            this.firstName=firstName;
            this.surname=surname;
            this.mobileNumbers=mobileNumbers;
            this.homeNumbers = homeNumbers;
            this.businessNumbers=businessNumbers;
            this.birthday = birthday;
        }catch (RuntimeException e){
            System.out.println("validation failed: " + e);
            throw new IllegalArgumentException();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOption(int option){
        switch(option){
            case 1:
                return nickname;
            case 2:
                return firstName;
            case 3:
                return surname;
            default:
                return "invalid option";
        }
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
        if (!(firstName.length()<=charCap)){
            throw new RuntimeException("firstname length invalid");
        }
        return true;
    }
    private boolean validateSurName(String surname)
    {
        if (!(surname.length()<=charCap))
            throw new RuntimeException("surname length invalid");
        return true;
    }
    private boolean validateNickname(String nickname)
    {
        if (!(nickname.length()<=charCap))
            throw new RuntimeException("nickname length invalid");
        return true;
    }

    private boolean __validationNumberMethod(String phoneNumber)
    {
        int min = 9;
        int max = 15;

        if (!(phoneNumber.length()>min && phoneNumber.length()<max))
            throw new RuntimeException(phoneNumber + " error. Length invalid");
        return true;
    }

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
