package Email_Id;

import java.util.Scanner;

public class EmailSearch {
    public static void main(String[] args) {
        // Array of email IDs
        String[] emailArray = {
            "john.doe@example.com",
            "jane.smith@example.com",
            "alice.jones@example.com",
            // Add more email IDs as needed
        };

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an email ID for searching
        System.out.print("Enter the email ID to search: ");
        String searchEmail = scanner.nextLine();

        // Perform the search
        boolean found = false;
        for (String email : emailArray) {
            if (email.equals(searchEmail)) {
                found = true;
                break;
            }
        }else{
            notfound = false;
            break;

        }
        // Display the result of the search
        if (found) {
            System.out.println("Email ID found in the array.");
        } else {
            System.out.println("Email ID not found in the array.");
        }
        
    }
}

