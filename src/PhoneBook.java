import java.util.ArrayList;
import java.util.TreeMap;

public class PhoneBook {
    TreeMap<Integer, Address> phoneAddress;

    public PhoneBook(){
        phoneAddress = new TreeMap<>();
    }

    public void add(String nickname, String firstName, String surname, String mobileNumber, String homeNumber, String businessNumber, String email, Date birthday){
    }

    public void update(){
    }

    public void delete(){

    }

    public Address getAddress(int id){
        return phoneAddress.get(id);
    }

    public void setEmergencyContact(boolean emergencyContact){

    }
}
