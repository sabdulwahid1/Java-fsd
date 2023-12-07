package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CameraRentalApplication {
	private static List<User> userList = new ArrayList<>();
    private static List<Camera> cameraList = new ArrayList<>();
    private static Wallet userWallet = new Wallet(100.0);
    private static User currentUser = null;

    public static void main(String[] args) {
    	initializeUsers();
    	initializeCameras();
    	
        Scanner scanner = new Scanner(System.in);
        
        loginOrSignup(scanner);
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listCameras();
                    break;
                case 2:
                    rentCamera(scanner);
                    break;
                case 3:
                    handleWallet(scanner);
                    break;
                case 4:
                    addCamera(scanner);
                    break;
                case 5:
                    removeCamera(scanner);
                    break;
                case 6:
                    viewMyCameras();
                    break;
                case 7:
                    goToPreviousMenu();
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    //initializeUsers
    private static void initializeUsers() {
		userList.add(new User("user1", "pass1", 200.0));
        userList.add(new User("user2", "pass2", 150.0));
		
	}
    
    //initializeCameras
    private static void initializeCameras() {
		cameraList.add(new Camera("Canon", "EOS 5D Mark IV", 25.0));
        cameraList.add(new Camera("Nikon", "D850", 30.0));
		
	}
    
    
    


    private static void loginOrSignup(Scanner scanner) {
    	System.out.println("+==========================================+");
    	System.out.println("|   WELCOME TO CAMERA RENTAL APPLICATION   |");
    	System.out.println("+==========================================+");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.print("Enter your choice: ");
        

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login(scanner);
                break;
            case 2:
                signup(scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }
		
	}

	private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + username + "!");
                return;
            }
        }

        System.out.println("Invalid credentials. Exiting.");
        System.exit(0);
    }
	
	private static void signup(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String newUsername = scanner.next();
        System.out.print("Enter a password: ");
        String newPassword = scanner.next();

        userList.add(new User(newUsername, newPassword, 100.0)); // Initial wallet balance
        System.out.println("Signup successful. Welcome, " + newUsername + "!");
        currentUser = userList.get(userList.size() - 1);
    }


	private static void displayMenu() {
        System.out.println("\n===== rentmycam.io =====");
        System.out.println("1. List Cameras");
        System.out.println("2. Rent a Camera");
        System.out.println("3. Wallet");
        System.out.println("4. Add Camera");
        System.out.println("5. Remove Camera");
        System.out.println("6. View My Rented Cameras");
        System.out.println("7. Go to Previous Menu");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
	
    private static void listCameras() {
    	
    	Camera myCamera = new Camera("Canon", "EOS 5D Mark IV", 25.0);
    	
    	int cameraId = myCamera.getCameraId();
    	System.out.println("Camera ID: " + cameraId);
    	
        if (cameraList.isEmpty()) {
            System.out.println("No cameras available.");
            return;
        }

        System.out.println("\n===== Camera List =====");
        System.out.println("========================================================");
        System.out.printf("%-10s %-15s %-15s %-15s\n","CameraId", "Brand", "Model", "Per Day Rent");
    	System.out.println("========================================================");
       

        for (int i = 0; i < cameraList.size(); i++) {
            Camera camera = cameraList.get(i);
            System.out.printf("%-10s %-15s %-15s %-15s\n",
                    camera.getCameraId(),camera.getBrand(), camera.getModel(), camera.getPerDayRentalAmount());
        }
        System.out.println("========================================================");
    }

    private static void rentCamera(Scanner scanner) {
        listCameras();

        if (cameraList.isEmpty()) {
            System.out.println("No cameras available for rent.");
            return;
        }

        System.out.print("Enter the number of the camera to rent: ");
        int cameraIndex = scanner.nextInt();

        if (cameraIndex < 0 || cameraIndex >= cameraList.size()) {
            System.out.println("Invalid camera selection.");
            return;
        }

        Camera selectedCamera = cameraList.get(cameraIndex);
        double rentalAmount = selectedCamera.getPerDayRentalAmount();

        if (rentalAmount > userWallet.getBalance()) {
            System.out.println("Insufficient Wallet Amount. Please add funds.");
            return;
        }
        
        currentUser.getWallet().addFunds(-rentalAmount);
        currentUser.getRentedCameras().add(selectedCamera);

        System.out.println("Camera rented successfully. Enjoy your photography session!");


        // Remove the rented camera from the list
        cameraList.remove(cameraIndex);

        // Display the updated list of available cameras
        System.out.println("\nRemaining Cameras:");
        listCameras();
    }

    private static void handleWallet(Scanner scanner) {
        System.out.println("\n===== Wallet =====");
        System.out.println("1. Add Funds");
        System.out.println("2. View Balance");
        System.out.print("Enter your choice: ");
        int walletChoice = scanner.nextInt();

        switch (walletChoice) {
            case 1:
                addFunds(scanner);
                break;
            case 2:
                System.out.println("Your current wallet balance: " + userWallet.getBalance());
                break;
            case 3:
            	System.out.println("Updated wallet balance: " + currentUser.getWallet().getBalance());
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addFunds(Scanner scanner) {
    	System.out.print("Enter the amount to add to your wallet: ");
        double amount = scanner.nextDouble();
        currentUser.getWallet().addFunds(amount);

    }

    private static void addCamera(Scanner scanner) {
        System.out.print("Enter camera brand: ");
        String brand = scanner.next();

        System.out.print("Enter camera model: ");
        String model = scanner.next();

        System.out.print("Enter per-day rental amount: ");
        double perDayRentalAmount = scanner.nextDouble();

        Camera newCamera = new Camera(brand, model, perDayRentalAmount);
        cameraList.add(newCamera);

        System.out.println("Camera added successfully!");
    }
    
    private static void removeCamera(Scanner scanner) {
        System.out.println("\n===== Remove Camera =====");
        listRentedCameras();

        if (currentUser.getRentedCameras().isEmpty()) {
            System.out.println("You have no rented cameras to remove.");
            return;
        }

        try {
            System.out.print("Enter the number of the camera to remove: ");
            int cameraIndex = scanner.nextInt();

            if (cameraIndex < 0 || cameraIndex >= currentUser.getRentedCameras().size()) {
                System.out.println("Invalid camera selection.");
                return;
            }

            Camera removedCamera = currentUser.getRentedCameras().remove(cameraIndex);
            cameraList.add(removedCamera);

            System.out.println("Camera removed successfully.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
        }
    }

    private static void viewMyCameras() {
        System.out.println("\n===== My Rented Cameras =====");
        listRentedCameras();
    }

    private static void listRentedCameras() {
        if (currentUser.getRentedCameras().isEmpty()) {
            System.out.println("You have no rented cameras.");
            return;
        }

        System.out.printf("%-10s %-15s %-15s\n", "Brand", "Model", "Per Day Rent");

        for (int i = 0; i < currentUser.getRentedCameras().size(); i++) {
            Camera camera = currentUser.getRentedCameras().get(i);
            System.out.printf("%-10s %-15s %-15s\n",
                    camera.getBrand(), camera.getModel(), camera.getPerDayRentalAmount());
        }
    }
    

    private static void goToPreviousMenu() {
        System.out.println("Going back to the main menu.");
    }
}


