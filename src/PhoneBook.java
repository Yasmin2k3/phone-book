import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneBook {
    ArrayList<Contact> contacts;

    public PhoneBook(String fileName){
        this.contacts = new ArrayList<>();
        readFromCSV(fileName);

        Scanner scanner = new Scanner(System.in);
    }

    public void add(Contact contact){
        //TODO: check if it is already in the phone book
        this.contacts.add(contact);
    }

    public void update(int id, Contact contact){
        this.contacts.set(id, contact);
    }

    public void sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what option to sort by:\n" +
                "1: Sort by nickname\n" +
                "2: Sort by first name\n" +
                "3: Sort by surname\n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                contacts.sort(Comparator.comparing(Contact::getNickname, String.CASE_INSENSITIVE_ORDER));
                break;
            case 2:
                contacts.sort(Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER));
                break;
            case 3:
                contacts.sort(Comparator.comparing(Contact::getSurname, String.CASE_INSENSITIVE_ORDER));
                break;
            default:
                System.out.println("Invalid option. Sorting cancelled.");
                return;
        }
        System.out.println("Contacts sorted successfully!");
    }

    public void delete(int id){
        System.out.println("REMOVED:\n" + contacts.get(id));
        this.contacts.remove(id);
    }

//    public String search(){
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Choose what option to search by:\n" +
//                "1: Search by nickname\n" +
//                "2: Search by firstname\n" +
//                "3: Search by surname\n");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//    }

    public String searchByName(String name) {
        int left = 0, right = contacts.size() - 1;
        int mid = -1;

        //binary search
        while (left <= right) {
            mid = left + (right - left) / 2;
            Contact midContact = contacts.get(mid);
            int comparison = midContact.getFirstName().compareToIgnoreCase(name);

            if (comparison == 0) {
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (mid == -1 || contacts.get(mid).getFirstName().compareToIgnoreCase(name) != 0) {
            return "Contact not found.";
        }

        // Expand to find all occurrences
        StringBuilder result = new StringBuilder();
        int start = mid, end = mid;

        // Find the leftmost occurrence
        while (start > 0 && contacts.get(start - 1).getFirstName().compareToIgnoreCase(name) == 0) {
            start--;
        }

        // Find the rightmost occurrence
        while (end < contacts.size() - 1 && contacts.get(end + 1).getFirstName().compareToIgnoreCase(name) == 0) {
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
            str.append("ID: ").append(i).append("\n").append(contacts.get(i).toString()).append("\n");
        }
        str.append("ID: ").append(contacts.size()-1).append("\n").append(contacts.getLast().toString());

        return str.toString();
    }

    public void writeToCSV(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            StringBuilder sb = new StringBuilder();
            for (Contact contact : contacts) {
                sb.append(contact.getNickname()).append(",")
                        .append(contact.getFirstName()).append(",")
                        .append(contact.getSurname()).append(",")
                        .append(contact.getMobileNumbers()).append(",")
                        .append(contact.getHomeNumbers()).append(",")
                        .append(contact.getBusinessNumbers()).append(",")
                        .append(contact.getBirthday()).append("\n");
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readFromCSV(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            contacts.clear();
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int[] date = Arrays.stream(data[6].split("/"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                Contact contact = new Contact(
                        data[0], data[1], data[2], data[3], data[4], data[5], new Date(date[0], date[1], date[2]));
                contacts.add(contact);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
            writeToCSV(fileName);
        }
    }
}
