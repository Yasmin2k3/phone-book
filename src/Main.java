import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void test() {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(new Contact("Yasmin", "Yasmin", "Woodlock", "0899583792", "0526135952", "1234567890", new Date(12, 11, 2003)));
        myPhoneBook.add(new Contact("Yas", "Yasmin", "Lock", "0899583792", "0526135952", "1234567890", new Date(12, 11, 2003)));
        myPhoneBook.add(new Contact("Y", "April", "Gilhool", "1234567890", "1234567890", "1234567890", new Date(12, 11, 2004)));
        //myPhoneBook.add(new Contact("Y", "April", "Gilhool", "1234590", "1234567890", "1234567890", new Date(12, 11, 2004)));


        System.out.println(myPhoneBook);

        System.out.println("SEARCH BY NAME");
        System.out.println(myPhoneBook.searchByName("Yasmin"));

        myPhoneBook.delete(2);
    }

    //public static void main(String[] args)
    //{
    //test()
    //PhoneBook myPhoneBook = new PhoneBook();
    //}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook myPhoneBook = new PhoneBook();
        boolean running = true;

        while (running) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Phone Book");
            System.out.println("3. Search Contact by First Name");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
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
                case 6:
                    running = false;
                    System.out.println("Exiting Phone Book.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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

        Contact newContact = new Contact(nickname, firstName, surname, mobileNumber, homeNumber, businessNumber, new Date(birthday[0], birthday[1], birthday[2]));
        phoneBook.add(newContact);
        System.out.println("Contact added successfully.");
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


    }
}