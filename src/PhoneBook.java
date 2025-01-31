import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook {
    ArrayList<Address> phoneAddress;

    public PhoneBook(){
        this.phoneAddress = new ArrayList<>();
    }

    public void add(Address address){
        this.phoneAddress.add(address);
        //TODO: change to binary search
        phoneAddress.sort(Comparator.comparing(Address::getFirstName));
    }

    public void add(String nickname, String firstName, String surname, String mobileNumber, String homeNumber, String businessNumber, String email, Date birthday){
        //TODO: check if it is already in the phone book
        add(new Address(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, email, birthday));
    }

    public void update(int id, Address address){
        this.phoneAddress.set(id, address);
    }

    public void delete(int id){
        this.phoneAddress.remove(id);
    }

    public String searchByName(String firstName) {
        int left = 0, right = phoneAddress.size() - 1;
        int mid = -1;

        // homemade binary search
        while (left <= right) {
            mid = left + (right - left) / 2;
            Address midAddress = phoneAddress.get(mid);
            int comparison = midAddress.getFirstName().compareToIgnoreCase(firstName);

            if (comparison == 0) {
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (mid == -1 || phoneAddress.get(mid).getFirstName().compareToIgnoreCase(firstName) != 0) {
            return "Contact not found.";
        }

        // Expand to find all occurrences
        StringBuilder result = new StringBuilder();
        int start = mid, end = mid;

        // Find the leftmost occurrence
        while (start > 0 && phoneAddress.get(start - 1).getFirstName().compareToIgnoreCase(firstName) == 0) {
            start--;
        }

        // Find the rightmost occurrence
        while (end < phoneAddress.size() - 1 && phoneAddress.get(end + 1).getFirstName().compareToIgnoreCase(firstName) == 0) {
            end++;
        }

        // Collect all matching addresses and their indexes
        for (int i = start; i <= end; i++) {
            result.append("Index: ").append(i).append(" - ").append(phoneAddress.get(i).toString()).append("\n");
        }

        return result.toString();
    }



    public Address getContact(int id){
        return phoneAddress.get(id);
    }

    public void setEmergencyContact(int id, boolean emergencyContact){phoneAddress.get(id).setEmergencyContact(emergencyContact);}


}
