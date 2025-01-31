import java.util.ArrayList;

public class PhoneBook {
    ArrayList<Address> phoneAddress;

    public PhoneBook(){
        phoneAddress = new ArrayList<>();
    }

    public void add(String nickname, String firstName, String surname, String mobileNumber, String homeNumber, String businessNumber, String email, Date birthday){
        phoneAddress.add(new Address(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, email, birthday));
    }

    public void update(){
    }

    public void delete(){

    }

    public String searchByName(String firstName){
        return "";
    }

    public Address getAddress(int id){
        return phoneAddress.get(id);
    }

    public void setEmergencyContact(boolean emergencyContact){

    }
}
