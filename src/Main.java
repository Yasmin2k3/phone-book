import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook myPhoneBook = new PhoneBook("test.csv");
        boolean running = true;

        while (running) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Phone Book");
            System.out.println("3. Search Contact by First Name");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Sort Phonebook");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addContact(myPhoneBook, scanner);
                    break;
                case 2:
                    System.out.println(myPhoneBook);
                    break;
                case 3:
                    searchContact(myPhoneBook, scanner);
                    break;
                case 4:
                    updateContact(myPhoneBook, scanner);
                    break;
                case 5:
                    System.out.println("Input id you want to delete.");
                    myPhoneBook.delete(scanner.nextInt());
                    break;
                case 6:
                    myPhoneBook.sort();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Phone Book.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        myPhoneBook.writeToCSV("test.csv");
        scanner.close();
    }

    // Method to add a contact
    private static void addContact(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter Nickname: ");
        String nickname = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter Home Number: ");
        String homeNumber = scanner.nextLine();

        System.out.print("Enter Business Number: ");
        String businessNumber = scanner.nextLine();

        System.out.println("Enter Birthdate as MM DD YYYY");
        String bDay = scanner.nextLine();
        int[] birthday = Arrays.stream(bDay.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        try{
            Contact newContact = new Contact(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, new Date(birthday[0], birthday[1], birthday[2]));
            phoneBook.add(newContact);
            System.out.println("Contact added successfully.");
        }catch(IllegalArgumentException e){
            System.out.println("Contact invalid.");
        }

    }

    // Method to search for a contact
    private static void searchContact(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter First Name to search: ");
        String firstName = scanner.nextLine();
        String result = phoneBook.searchByName(firstName);
        System.out.println(result);
    }

    // Method to update a contact
    private static void updateContact(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter Contact ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (id < 0 || id >= phoneBook.contacts.size()) {
            System.out.println("Invalid Contact ID.");
            return;
        }

        System.out.print("Enter New Nickname: ");
        String nickname = scanner.nextLine();

        System.out.print("Enter New First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter New Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter New Mobile Number: ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter New Home Number: ");
        String homeNumber = scanner.nextLine();

        System.out.print("Enter New Business Number: ");
        String businessNumber = scanner.nextLine();

        System.out.println("Enter New Birthday as MM DD YYYY");
        String bDay = scanner.nextLine();
        int[] birthday = Arrays.stream(bDay.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        try{
            Contact newContact = new Contact(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, new Date(birthday[0], birthday[1], birthday[2]));
            phoneBook.add(newContact);
            System.out.println("Contact updated successfully.");
        }catch(IllegalArgumentException e){
            System.out.println("New contact invalid.");
        }
    }
}