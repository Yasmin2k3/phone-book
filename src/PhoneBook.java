import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {
    ArrayList<Address> phoneAddress;

    public PhoneBook(){
        this.phoneAddress = new ArrayList<>();
    }

    public void add(String nickname, String firstName, String surname, String mobileNumber, String homeNumber, String businessNumber, String email, Date birthday){
        //TODO: check if it is already in the phone book
        this.phoneAddress.add(new Address(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, email, birthday));
        //TODO: change to binary search
        phoneAddress.sort(Comparator.comparing(Address::getFirstName));
    }

    public void update(int id, Address address){
        this.phoneAddress.set(id, address);
    }

    public void delete(int id){
        this.phoneAddress.remove(id);
    }

    public String searchByName(String firstName){
        return "";
    }

    public Address getAddress(int id){
        return phoneAddress.get(id);
    }

    public void setEmergencyContact(int id, boolean emergencyContact){phoneAddress.get(id).setEmergencyContact(emergencyContact);}


}
