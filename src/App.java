import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class App {
    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    /* 
     MAIN function
    */

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+"Hello, World!"+ANSI_RESET);


        //error solving
        try {getUserInfo();} catch (IOException e) {System.out.println("Error occurred while saving user data: " + e.getMessage());}
                }

        /*
         * function to get the user input like name, username ecc...
         */

    public static void getUserInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);

        //name
        System.out.print(ANSI_BLUE+"What is your name?\n"+ANSI_RESET);
        String name = scanner.nextLine();

        //last name
        System.out.print(ANSI_BLUE+"What is your last name?\n"+ANSI_RESET);
        String surname = scanner.nextLine();

        //age
        System.out.print(ANSI_BLUE+"How old are you?\n"+ANSI_RESET);
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        //phone number 
        System.out.print(ANSI_BLUE+"What is your phone number?\n"+ANSI_RESET);
        var phone = scanner.nextLong();
        scanner.nextLine(); // consume the newline character

        //email
        System.out.print(ANSI_BLUE+"What is your email?\n"+ANSI_RESET);
        var email = scanner.nextLine();

        scanner.close();
        try {
            saveUserData(name, surname, age, phone, email);} catch (IOException e) {System.out.println("Error saving user data to file.");e.printStackTrace();}
    }
    
    /*
     * function to save the user input to the data.csv file
     */

    public static void saveUserData(String name, String surname, int age, Long phone, String email) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("data.csv"));
        String[] header = { "Name", "Surname", "Age", "Phone", "Email" };
        writer.writeNext(header);
        String[] data = { name, surname, Integer.toString(age),Long.toString(phone), email };
        writer.writeNext(data);
        writer.close();
    }
}
