import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(new Contact("Y", "Yasmin", "Woodlock", "0899583792", "0526135952", "", "yasmonso@gmail.com", new Date(12, 11, 2003)));

        System.out.println(myPhoneBook);
    }
}
