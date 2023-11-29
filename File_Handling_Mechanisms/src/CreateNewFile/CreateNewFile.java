package CreateNewFile;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        // Specify the path and name of the file to be created
        String filePath = "!";

        // Create a File object
        File file = new File(filePath);

        try {
            // Check if the file already exists
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists at: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}


