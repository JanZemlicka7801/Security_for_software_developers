package Lab_5;

import java.security.*;
import java.util.*;

public class HashSalt {

    /**
     * Hashes passed password using SHA-256 algorithm.
     *
     * @param password The password to be hashed.
     * @return The hashed password.
     * @throws NoSuchAlgorithmException Throws an exception while using the algorithm.
     */

    public static String hash(String password) throws NoSuchAlgorithmException {
        //password to be hashed
        byte[] inputBytes = password.getBytes();
        //the algorithm for hashing
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //hash the input
        byte[] outputBytes = md.digest(inputBytes);
        //encode the hash bytes
        return Base64.getEncoder().encodeToString(outputBytes);
    }

    /**
     * Generates a random salt.
     *
     * @return The generated salt.
     */

    public static String salt(){
        //array of 32 bytes to store random bytes
        byte[] saltBytes = new byte[32];
        SecureRandom random = new SecureRandom();
        //byte array filled with random bytes
        random.nextBytes(saltBytes);
        //return random bytes encoded as a base64 string
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    /**
     * Hashes passed password with salt using SHA-256 algorithm.
     *
     * @param password The password to be hashed.
     * @param salt The salt to be added to password before hashing.
     * @return The hashed password.
     * @throws NoSuchAlgorithmException Throws an exception while using the algorithm.
     */

    public static String hashSalt(String password, String salt) throws NoSuchAlgorithmException {
        //password and salt into one password
        String saltPassword = password + salt;
        //password to be hashed
        byte[] inputBytes = saltPassword.getBytes();
        //the algorithm for hashing
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //hash the input
        byte[] outputBytes = md.digest(inputBytes);
        //encode the hash bytes
        return Base64.getEncoder().encodeToString(outputBytes);
    }

    /**
     * Verifies if the password hashed with salt matches the passed hashed password.
     *
     * @param password The password to be verified.
     * @param hashedPassword The hashed password to be compared with.
     * @param salt The salt to be added to password before hashing.
     * @return True if verification is successful, false otherwise.
     * @throws NoSuchAlgorithmException Throws an exception while using the algorithm.
     */

    public static boolean verify(String password, String hashedPassword, String salt) throws NoSuchAlgorithmException {
        String hashed = hashSalt(password, salt);

        return hashed.equals(hashedPassword);
    }
}
