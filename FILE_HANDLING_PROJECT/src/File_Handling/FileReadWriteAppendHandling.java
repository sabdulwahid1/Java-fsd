package File_Handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWriteAppendHandling {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // File path
	        String filePath = "FileHandling.txt";

	        // Writing to a file
	        System.out.print("Enter content to write the file: ");
	        String contentToWrite = scanner.nextLine();
	        writeToFile(filePath, contentToWrite);
	        System.out.println("Content written to the file successfully.");

	        // Reading from a file
	        String contentToRead = readFromFile(filePath);
	        System.out.println("Content read from the file: " + contentToRead);

	        // Appending to a file
	        System.out.print("Enter content to append to the file: ");
	        String contentToAppend = scanner.nextLine();
	        appendToFile(filePath, contentToAppend);
	        System.out.println("Content appended to the file successfully.");

	        scanner.close();
	    }

	    // Method to write content to a file
	    private static void writeToFile(String filePath, String content) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(content);
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	    }

	    // Method to read content from a file
	    private static String readFromFile(String filePath) {
	        StringBuilder content = new StringBuilder();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }

	        return content.toString();
	    }

	    // Method to append content to a file
	    private static void appendToFile(String filePath, String content) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
	            writer.write(content);
	        } catch (IOException e) {
	            System.err.println("Error appending to the file: " + e.getMessage());
	        }
	    }
}
