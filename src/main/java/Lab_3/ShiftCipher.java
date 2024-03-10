package Lab_3;

public class ShiftCipher {

    /**
     * Encrypts passed text using shift cipher with shift value.
     *
     * @param text The text to be encrypted.
     * @param shift The value to shift characters.
     * @return The encrypted text.
     */
    public static String encrypt(String text, int shift){
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()){
            result.append((char) (character + shift));
        }

        return result.toString();
    }

    /**
     * Decrypts passed text using shift cipher back with shift value.
     *
     * @param text The text to be decrypted.
     * @param shift The value for decryption.
     * @return The decrypted text.
     */
    public static String decrypt(String text, int shift){
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()){
            result.append((char) (character - shift));
        }

        return result.toString();
    }

    /**
     * Main method to test created methods.
     */
    public static void main(String[] args) {
        String text = "Security for Software Development";
        int key = -17;

        String encryptedText = ShiftCipher.encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);
        String decryptedText = ShiftCipher.decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
