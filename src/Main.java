import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
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
}
