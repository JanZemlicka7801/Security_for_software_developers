package Lab_3;

public class CeasarCipher {

    /**
     * Encrypts a passed text using a Ceasar method with passed key.
     * Uppercase and lowercase letters are shifted using the passed key.
     *
     * @param text The text to be encrypted.
     * @param key The key used to shift the letters.
     * @return The encrypted text.
     */
    public static String encrypt(String text, int key){
        StringBuilder result = new StringBuilder();
        char[] letters = text.toCharArray();

        for (char letter : letters) {
            // can write uppercase letters
            if (letter >= 'A' && letter <= 'Z') {
                result.append((char) (Math.floorMod((letter - 'A') + key, 26) + 'A'));
                // can write lowercase letters
            } else if (letter >= 'a' && letter <= 'z') {
                result.append((char) (Math.floorMod((letter - 'a') + key, 26) + 'a'));
                // can write special characters and spaces
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

    /**
     * Decrypts a passed text using a Ceasar method with passed key to decrypt the text.
     * Uppercase and lowercase letters are shift back.
     *
     * @param text The text to be decrypted.
     * @param key The key for decryption.
     * @return The decrypted text.
     */
    public static String decrypt (String text, int key){
        StringBuilder decrypt = new StringBuilder();
        char[] letters = text.toCharArray();

        for (char letter : letters) {
            // can write uppercase letters
            if (letter >= 'A' && letter <= 'Z') {
                decrypt.append((char) (Math.floorMod((letter - 'A') + (key * -1), 26) + 'A'));
                // can write lowercase letters
            } else if (letter >= 'a' && letter <= 'z') {
                decrypt.append((char) (Math.floorMod((letter - 'a') + (key * -1), 26) + 'a'));
                // can write special characters and spaces
            } else {
                decrypt.append(letter);
            }
        }
        return decrypt.toString();
    }

    /**
     * Main method to test created methods.
     */
    public static void main(String[] args) {
        String text = "Security for Software Developmentw";
        int key = -17;

        String encryptedText = CeasarCipher.encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);
        String decryptedText = CeasarCipher.decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
