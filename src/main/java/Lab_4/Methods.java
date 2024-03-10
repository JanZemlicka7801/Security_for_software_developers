package Lab_4;

import Lab_3.CeasarCipher;

import java.io.*;
import java.util.Scanner;

public class Methods {

    /**
     * Gets a valid integer from the user through scanner.
     *
     * @param scanner The scanner for user's input.
     * @return The valid integer (choice of user).
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
     * Reads the file and return it as a String.
     *
     * @param fileName The file to be read from.
     * @return The content of the file as a String.
     * @throws IOException Throws an exception while reading the file.
     */

    public static String readFromFile(File fileName) throws IOException {
        StringBuilder sup = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sup.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return sup.toString();
    }

    /**
     * Writes provided text into a file.
     *
     * @param file The file to be written into.
     * @param text The content to be written into the file.
     */

    public static void writeToFile(File file, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter((file)))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    /**
     * Decrypts the content of a file using Ceasar method created in previous lab.
     *
     * @param file The file with content to be decrypted.
     * @param key The key for decryption.
     * @return The decrypted content.
     * @throws IOException Throws an error while reading or decrypting file.
     */

    public static String decryptFile(File file, int key) throws IOException {
        String content = readFromFile(file);
        return CeasarCipher.decrypt(content, key);
    }

    /**
     * Decrypts the passed file content using brute force decryption.
     * Prints the key when the match is found.
     *
     * @param fileInput The file to be force brute decrypted.
     * @param word The word to search for in file.
     */

    public static void bruteForceDecrypt(File fileInput, String word) {
        for (int key = 1; key < 26; key++) {
            try {
                String deContent = decryptFile(fileInput, key);
                if (deContent.contains(word)) {
                    System.out.println("Match found with the key " + key + ".");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Error decrypting file content.");
                return;
            }
        }
        System.out.println("Key for the word was not found.");
    }
}
