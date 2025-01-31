import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(new Contact("Yasmin", "Yasmin", "Woodlock", "0899583792", "0526135952", "1234567890", new Date(12, 11, 2003)));

        System.out.println(myPhoneBook);
    }
}
