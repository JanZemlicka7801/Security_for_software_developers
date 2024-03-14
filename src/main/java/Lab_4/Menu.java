package Lab_4;
import Lab_1.Patterns;
import Lab_1.Patterns.*;
import Lab_3.CeasarCipher;
import Lab_5.HashSalt;
import Lab_6.Diffie_Hellman;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

//needs to create a shift cipher and implement case 4 with also improving the menu bar because of the last lab

/**
 * Menu provides a program for encryption and decryption using ceasar method,
 * created in previous labs. As well as password hashing and brute force decryption.
 */

public class Menu {
    private static String salt;
    private static String hashedPassword;

    /**
     * Main method to execute the menu.
     */

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        int choice;
                while (true) {
                    System.out.println("1. Encrypt a password\n" +
                            "2. Encrypt a text file\n" +
                            "3. Decrypt a text file\n" +
                            "4. Brute force decrypt the file\n" +
                            "5. Hash your password\n" +
                            "6. Verify password\n" +
                            "7. Generate a shared private key\n" +
                            "8. Exit\n" +
                            "Enter your choice: ");
                    choice = Methods.getChoice(sc);
                    switch (choice) {
                        case 1:
                            try {
                                System.out.println("Enter the password to encrypt: ");
                                String password = sc.nextLine();
                                System.out.println("Enter the key for encryption: ");
                                int key = Integer.parseInt(sc.nextLine());
                                String encryptedPassword = CeasarCipher.encrypt(password, key);
                                System.out.println("Encrypted password: " + encryptedPassword);
                            } catch (NumberFormatException e) {
                                System.out.println("Enter number.");
                            }
                            break;
                        case 2:
                            System.out.println("Enter name of the file: ");
                            String file = sc.nextLine();
                            System.out.println("Enter the encryption key: ");
                            try {
                                int key = sc.nextInt();
                                File fileInput = new File(file);
                                String content = Methods.readFromFile(fileInput);
                                String coded = CeasarCipher.encrypt(content, key);
                                Methods.writeToFile(fileInput, coded);
                                System.out.println(coded);
                            } catch (InputMismatchException | IOException e) {
                                System.out.println("Invalid key or file was not found, try it again.");
                            }
                            break;
                        case 3:
                            System.out.println("Please enter name of the file you want to decrypt :");
                            String path = sc.nextLine();
                            System.out.println("Please enter the key for decryption :");
                            try {
                                int key = sc.nextInt();
                                File fileInput = new File(path);
                                String content = Methods.readFromFile(fileInput);
                                String crypt = CeasarCipher.decrypt(content, key);
                                Methods.writeToFile(fileInput, crypt);
                            } catch (InputMismatchException | IOException e) {
                                System.out.println("Error occurred, try it again.");
                            }
                            break;
                        case 4:
                            System.out.println("Please enter a file to brute force decrypt :");
                            String pathFile = sc.nextLine();
                            System.out.println("Enter a word to search for in the text file :");
                            String word = sc.nextLine();

                            try {
                                File brutFile = new File(pathFile);
                                Methods.bruteForceDecrypt(brutFile, word);
                            } catch (NullPointerException e){
                                System.out.println("Cannot be null.");
                            }
                            break;
                        case 5:
                            System.out.println("Enter a password to hash :");
                            String password = sc.nextLine();

                                if (Patterns.password(password)){
                                    salt = HashSalt.salt();
                                    hashedPassword = HashSalt.hashSalt(password, salt);
                                    System.out.println("Hashed password : " + hashedPassword);
                                    System.out.println("Salt : " + salt);
                                } else {
                                    System.out.println("Invalid password. It must contain at least\n" +
                                            "one lowercase letter, one uppercase letter, one digit and one special character.\n" +
                                            "The total length needs to be 12 characters.\n");
                                }
                            break;
                        case 6:
                            System.out.println("Please enter a password to check :");
                            String passwordCheck = sc.nextLine();

                            if (HashSalt.verify(passwordCheck, hashedPassword, salt)){
                                System.out.println("Password is correct.");
                            } else {
                                System.out.println("Password is incorrect.");
                            }
                            break;
                        case 7:
                            Diffie_Hellman.part_6(sc);
                            break;
                        case 8:
                            System.out.println("You exit the program.");
                            sc.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
        }
}
