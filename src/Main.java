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
                    myPhoneBook.add();
                    break;
                case 2:
                    System.out.println(myPhoneBook);
                    break;
                case 3:
                    searchContact(myPhoneBook, scanner);
                    break;
                case 4:
                    myPhoneBook.update();
                    break;
                case 5:
                    System.out.println("Input id you want to delete.");
                    myPhoneBook.delete(scanner.nextLine());
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
        scanner.close();
    }
    // Method to search for a contact
    private static void searchContact(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter First Name to search: ");
        String firstName = scanner.nextLine();
        String result = phoneBook.searchByName(firstName);
        System.out.println(result);
    }
}