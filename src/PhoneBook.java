import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook {
    ArrayList<Contact> contacts;

    public PhoneBook(){
        this.contacts = new ArrayList<>();
    }

    public void add(Contact contact){
        //TODO: check if it is already in the phone book
        this.contacts.add(contact);
        //TODO: change to binary search
        contacts.sort(Comparator.comparing(Contact::getFirstName));
    }

    public void update(int id, Contact contact){
        this.contacts.set(id, contact);
        contacts.sort(Comparator.comparing(Contact::getFirstName));
    }

    public void delete(int id){
        this.contacts.remove(id);
    }

    public String searchByName(String firstName) {
        int left = 0, right = contacts.size() - 1;
        int mid = -1;

        //binary search
        while (left <= right) {
            mid = left + (right - left) / 2;
            Contact midContact = contacts.get(mid);
            int comparison = midContact.getFirstName().compareToIgnoreCase(firstName);

            if (comparison == 0) {
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (mid == -1 || contacts.get(mid).getFirstName().compareToIgnoreCase(firstName) != 0) {
            return "Contact not found.";
        }

        // Expand to find all occurrences
        StringBuilder result = new StringBuilder();
        int start = mid, end = mid;

        // Find the leftmost occurrence
        while (start > 0 && contacts.get(start - 1).getFirstName().compareToIgnoreCase(firstName) == 0) {
            start--;
        }

        // Find the rightmost occurrence
        while (end < contacts.size() - 1 && contacts.get(end + 1).getFirstName().compareToIgnoreCase(firstName) == 0) {
            end++;
        }

        // Collect all matching addresses and their indexes
        for (int i = start; i <= end; i++) {
            result.append("ID: ").append(i).append(" - ").append(contacts.get(i).toString()).append("\n");
        }

        return result.toString();
    }

    public Contact getContact(int id){
        return contacts.get(id);
    }

    public void setEmergencyContact(int id, boolean emergencyContact){
        contacts.get(id).setEmergencyContact(emergencyContact);}

    public String toString(){
        StringBuilder str = new StringBuilder();

        for(int i=0; i<contacts.size()-1; i++){
            str.append("ID: ").append(i).append(" - ").append(contacts.get(i).toString()).append("\n");
        }
        str.append("ID: ").append(contacts.size()-1).append(" - ").append(contacts.getLast().toString());

        return str.toString();
    }
}
