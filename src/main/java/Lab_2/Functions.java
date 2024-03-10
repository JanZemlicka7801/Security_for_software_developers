package Lab_2;

import java.util.Scanner;
import java.lang.Exception;

public class Functions {

    /**
     * Displays a welcome message for the validation app.
     */
    public static void welcome(){
        System.out.println("Welcome to a brand new validation app.\n" +
                "Please select one of the following options.");
    }

    /**
     * Displays the validation menu with options.
     */
    public static void displayMenu(){
        System.out.println("Validation Menu:\n" +
                "1. Password\n" +
                "2. Email\n" +
                "3. Phone number\n" +
                "4. Full name\n" +
                "5. Exit\n" +
                "Enter your choice: ");
    }

    /**
     * Takes user input and ensures it is a valid number.
     *
     * @param scanner The Scanner object to read user input.
     * @return The validated user choice as an integer.
     */
    public static int getChoice(Scanner scanner){
        int choice = 0;

        while(choice == 0) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        return choice;
    }

    /**
     * Validates a password based on specific criteria.
     *
     * @param scanner The Scanner object to read user input.
     */
    public static void validatePassword(Scanner scanner){
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if (password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{12}$")) {
            System.out.println("Valid Password!");
        } else {
            System.out.println("Invalid password. It must contain at least\n" +
                    "one lowercase letter, one uppercase letter, one digit and one special character.\n" +
                    "The total length needs to be 12 characters.\n" +
                    "Enter password again: ");
        }
    }

    /**
     * Validates an email address based on specific criteria.
     *
     * @param scanner The Scanner object to read user input.
     */
    public static void validateEmail(Scanner scanner){
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        if (email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Valid Email!");
        } else {
            System.out.println("Invalid email. It must start with one or more of any characters,\n" +
                    "then followed by '@' followed by letters, numbers, dots or hyphens.\n" +
                    "Followed by dot and end with at least two letters uppercase or lowercase.");
        }
    }

    /**
     * Validates a phone number based on specific criteria.
     *
     * @param scanner The Scanner object to read user input.
     */
    public static void validatePhoneNumber(Scanner scanner){
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches("^(\\+3538[1-9]|08[1-9]|8[1-9]|35308[1-9]|003538[1-9])\\d{7}$")) {
            System.out.println("Valid Phone Number!");
        } else {
            System.out.println("Invalid phone number. It must be in following formats: \n" +
                    "+3538.., 08.., 8.., 35308.. or 003538.. Other formats are invalid.");
        }
    }

    /**
     * Validates a full name based on specific criteria.
     *
     * @param scanner The Scanner object to read user input.
     */
    public static void validateFullName(Scanner scanner){
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();
        if (fullName.matches("^[A-Za-z]+\\s+[A-Za-z]+$")){
            System.out.println("Valid full name!");
        } else {
            System.out.println("Invalid full name. It needs to start with one or more lower or uppercase letters.\n" +
                    "Followed by one or more spaces and ends with one or more last names.");
        }
    }

    /**
     * Main application logic that drives the validation app.
     * It displays the menu, validates user input, and performs the chosen validation.
     * Exits the program if the user chooses to exit.
     */
    public static void app(){
        Scanner scanner = new Scanner(System.in);

        welcome();
        while(true){
            displayMenu();
            int choice = getChoice(scanner);

            switch (choice){
                case 1:
                    validatePassword(scanner);
                    break;
                case 2:
                    validateEmail(scanner);
                    break;
                case 3:
                    validatePhoneNumber(scanner);
                    break;
                case 4:
                    validateFullName(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program... Thank you for using our services.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter valid number (1-5).");
            }
        }
    }
}

